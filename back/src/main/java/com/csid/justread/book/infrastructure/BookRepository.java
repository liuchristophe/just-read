package com.csid.justread.book.infrastructure;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.dao.AuthorDao;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.dao.PublisherDao;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookRepository {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    public BookRepository(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.publisherDao = publisherDao;
    }

    public BookDto create(BookEntity book){

        /** updated : on s'assure que book.author n'est pas null pour éviter les erreurs 500 **/
        //Vérification existence auteur
        AuthorEntity author = book.getAuthor();

        PublisherEntity publisher = book.getPublisher();

        //Si l'auteur n'existe pas on le créer
        if (author != null) {

            Optional<AuthorEntity> optAuthorEntity = authorDao.findAuthorByLastnameAndFirstnameAndPseudo(author.getLastname(), author.getFirstname(), author.getPseudo());
            if (!optAuthorEntity.isPresent()) {
                authorDao.save(author);
            }
            book.setAuthor(optAuthorEntity.orElse(null));
        }

        //Si l'auteur n'existe pas on le créer
        if (publisher != null) {

            Optional<PublisherEntity> optPublisherEntity = publisherDao.findPublisherByName(publisher.getName());
            if (!optPublisherEntity.isPresent()) {
                publisherDao.save(publisher);
            }
            book.setPublisher(optPublisherEntity.orElse(null));
        }

        BookDto result = BookMapper.entityToDto(bookDao.save(book));
        return result;
    }
    public List<BookDto> getBooks() {
        return this.bookDao.findAll().stream().map(
                b -> BookMapper.entityToDto(b)
        ).collect(Collectors.toList());
    }
    public Optional<BookDto> getBookById(UUID id) {
        return this.bookDao.findById( id ).map( b -> BookMapper.entityToDto( b ) );
    }
    public List<BookDto> getBooksByCategoryName(String categoryName) {
        Optional<CategoryEntity> optCategoryEntity = this.categoryDao.findByName( categoryName );
        return ( ( optCategoryEntity.isPresent() ) ? this.bookDao.getAllBookByCategories(optCategoryEntity.get()).stream().map(b -> BookMapper.entityToDto(b)).collect(Collectors.toList()) : new ArrayList<BookDto>() ); /* Todo: lever une exception si la condition n'est pas vérifiée */
    }
    public List<BookDto> getBooksByPublisherName(String publisherName) {

        return this.bookDao.getAllBookByPublisherName(publisherName)
                .stream()
                .map(b -> BookMapper.entityToDto(b))
                .collect(Collectors.toList());
    }


}
