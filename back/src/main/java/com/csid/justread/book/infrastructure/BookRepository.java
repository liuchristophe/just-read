package com.csid.justread.book.infrastructure;

import com.csid.justread.book.AuthorMapper;
import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.model.Author;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.infrastructure.dao.AuthorDao;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.dao.EditionDao;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookRepository {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private EditionDao editionDao;
    private CategoryDao categoryDao;
    public BookRepository(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    public Book save(Book book){

        /** updated : on s'assure que book.author n'est pas null pour éviter les erreurs 500 **/
        //Vérification existence auteur
        Author author = book.getAuthor();

        //Si l'auteur n'existe pas on le créer
        if (author != null) {

            Optional<AuthorEntity> optAuthorEntity = authorDao.findAuthorByLastnameAndFirstnameAndPseudo(author.getLastname(), author.getFirstname(), author.getPseudo());
            if (!optAuthorEntity.isPresent()) {
                authorDao.saveAndFlush(AuthorMapper.authorToEntity(book.getAuthor()));
                optAuthorEntity = authorDao.findAuthorByLastnameAndFirstnameAndPseudo(author.getLastname(), author.getFirstname(), author.getPseudo());
            }
            book.setAuthor(AuthorMapper.entityToAuthor(optAuthorEntity.orElse(null)));
        }
        return BookMapper.entityToBook(bookDao.save( BookMapper.bookToEntity( book )));
    }
    public List<Book> getBooks() {
        return this.bookDao.findAll().stream().map(
                b -> BookMapper.entityToBook(b)
        ).collect(Collectors.toList());
    }
    public Optional<Book> getBookById(long id) {
        return this.bookDao.findById( id ).map( b -> BookMapper.entityToBook( b ) );
    }
    public List<Book> getBooksByCategoryName(String categoryName) {
        Optional<CategoryEntity> optCategoryEntity = this.categoryDao.findByName( categoryName );
        return ( ( optCategoryEntity.isPresent() ) ? this.bookDao.getAllBookByCategories(optCategoryEntity.get()).stream().map(b -> BookMapper.entityToBook(b)).collect(Collectors.toList()) : new ArrayList<Book>() ); /* Todo: lever une exception si la condition n'est pas vérifiée */
    }

}
