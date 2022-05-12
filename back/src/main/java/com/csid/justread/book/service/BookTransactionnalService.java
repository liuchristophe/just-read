package com.csid.justread.book.service;

import com.csid.justread.Converter;
import com.csid.justread.book.infrastructure.dao.AuthorDao;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.dao.PublisherDao;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;
import com.csid.justread.book.service.model.Author;
import com.csid.justread.book.service.model.Book;
import com.csid.justread.book.service.model.Category;
import com.csid.justread.book.service.model.Publisher;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class BookTransactionnalService {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private CategoryDao categoryDao;
    private PublisherDao publisherDao;
    public BookTransactionnalService(BookDao bookDao, AuthorDao authorDao, CategoryDao categoryDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.publisherDao = publisherDao;
    }

    public Book create(Book book){

        BookEntity bookEntity = new Converter().map(book, BookEntity.class);
        //Si l'auteur n'existe pas on le créer
        if (book.getAuthor() != null) bookEntity.setAuthor(getOrCreateAuthor(book.getAuthor()));
        //Si le publisher n'existe pas on le créer
        if (book.getPublisher() != null) bookEntity.setPublisher(getOrCreatePublisher(book.getPublisher()));
        //Si la catégorie n'existe pas on la crée
        if (book.getCategories() != null) bookEntity.setCategories(getOrCreateCategories(book.getCategories()));

        return new Converter().map(this.bookDao.save(bookEntity), Book.class);
    }

    public List<Book> getBooks() {
        return new Converter().mapAsList(this.bookDao.findAll(), Book.class);
    }

    public List<Book> getBooksByAuthorID(UUID authorID){
        return new Converter().mapAsList(this.bookDao.getAllBookByAuthorId(authorID), Book.class);
    }

    public Optional<Book> getBookById(UUID id) {
        return this.bookDao.findById( id ).map(book -> new Converter().map(book, Book.class));
    }

    public List<Book> getBooksByCategoryName(String categoryName) {

        return new Converter().mapAsList(this.bookDao.getAllBookByCategoriesName(categoryName), Book.class);
    }

    public List<Book> getBooksByPublisherName(String publisherName) {

        return new Converter().mapAsList(this.bookDao.getAllBookByPublisherName(publisherName), Book.class);
    }

    public Book update(UUID id, Book book) {
        Optional<BookEntity> optBookEntity = bookDao.findById(id);
        if(!optBookEntity.isPresent()) return null;

        BookEntity result = optBookEntity.get();
        if(book.getCategories()!=null) result.setCategories(getOrCreateCategories(book.getCategories()));
        if(book.getAuthor()!=null) result.setAuthor(getOrCreateAuthor(book.getAuthor()));
        if(book.getIsbn()!=null) result.setIsbn(book.getIsbn());
        if(book.getPublisher()!=null) result.setPublisher(getOrCreatePublisher(book.getPublisher()));
        if(book.getSynopsys()!=null) result.setSynopsys(book.getSynopsys());
        if(book.getTitle()!=null) result.setTitle(book.getTitle());
        if(book.getYear()!=null) result.setYear(book.getYear());

        return new Converter().map(bookDao.save(result), Book.class);
    }

    public void delete(UUID id){
        Optional<BookEntity> optBookEntity = bookDao.findById(id);
        if(optBookEntity.isPresent()) bookDao.delete(optBookEntity.get());
    }

    private AuthorEntity getOrCreateAuthor(Author author){

        return authorDao.findAuthorByLastnameAndFirstnameAndPseudo(
                author.getLastname(), author.getFirstname(), author.getPseudo())
                .orElseGet(() -> authorDao.save(new Converter().map(author, AuthorEntity.class)));
    }

    private PublisherEntity getOrCreatePublisher(Publisher publisher){
        return publisherDao.findPublisherByName(publisher.getName())
                .orElseGet(() -> publisherDao.save(new Converter().map(publisher, PublisherEntity.class)));
    }

    private List<CategoryEntity> getOrCreateCategories(List<Category> categories){
        return categories.stream()
                .map(category -> categoryDao.findByName(category.getName())
                                .orElseGet(() -> categoryDao.save(new Converter().map(category, CategoryEntity.class))))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitle(String title) {
        List<BookEntity> bookEntities = this.bookDao.findByTitle( title );
        return bookEntities.stream()
                .map( b -> new Converter().map(b, Book.class) )
                .collect(Collectors.toList());
    }
}
