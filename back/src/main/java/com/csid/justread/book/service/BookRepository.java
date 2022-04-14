package com.csid.justread.book.service;

import com.csid.justread.book.api.dto.BookDto;
import com.csid.justread.book.infrastructure.dao.AuthorDao;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.dao.PublisherDao;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;
import org.springframework.stereotype.Component;


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

    public BookEntity create(BookEntity book){

        //Si l'auteur n'existe pas on le créer
        if (book.getAuthor() != null) book.setAuthor(getOrCreateAuthor(book.getAuthor()));
        //Si le publisher n'existe pas on le créer
        if (book.getPublisher() != null) book.setPublisher(getOrCreatePublisher(book.getPublisher()));

        //Si la catégorie n'existe pas on la crée
        if (book.getCategories() != null) book.setCategories(getOrCreateCategories(book.getCategories()));

        return bookDao.save(book);
    }


    public List<BookEntity> getBooks() {
        return this.bookDao.findAll();
    }


    public List<BookEntity> getBooksByAuthorID(UUID authorID){
        return this.bookDao.getAllBookByAuthorId(authorID);
    }


    public Optional<BookEntity> getBookById(UUID id) {
        return this.bookDao.findById( id );
    }


    public List<BookEntity> getBooksByCategoryName(String categoryName) {

        return this.bookDao.getAllBookByCategoriesName(categoryName);
    }


    public List<BookEntity> getBooksByPublisherName(String publisherName) {

        return this.bookDao.getAllBookByPublisherName(publisherName);
    }


    public BookEntity update(UUID id, BookEntity bookEntity) {
        Optional<BookEntity> optBookEntity = bookDao.findById(id);
        if(!optBookEntity.isPresent()) return null;

        BookEntity result = optBookEntity.get();
        System.out.println(bookEntity.getAuthor());
        if(bookEntity.getCategories()!=null) result.setCategories(getOrCreateCategories(bookEntity.getCategories()));
        if(bookEntity.getAuthor()!=null) result.setAuthor(getOrCreateAuthor(bookEntity.getAuthor()));
        if(bookEntity.getIsbn()!=null) result.setIsbn(bookEntity.getIsbn());
        if(bookEntity.getPublisher()!=null) result.setPublisher(getOrCreatePublisher(bookEntity.getPublisher()));
        if(bookEntity.getSynopsys()!=null) result.setSynopsys(bookEntity.getSynopsys());
        if(bookEntity.getTitle()!=null) result.setTitle(bookEntity.getTitle());
        if(bookEntity.getYear()!=null) result.setYear(bookEntity.getYear());

        return bookDao.save(result);
    }

    public void delete(UUID id){
        Optional<BookEntity> optBookEntity = bookDao.findById(id);
        if(optBookEntity.isPresent()) bookDao.delete(optBookEntity.get());
    }

    private AuthorEntity getOrCreateAuthor(AuthorEntity author){

        return authorDao.findAuthorByLastnameAndFirstnameAndPseudo(
                author.getLastname(), author.getFirstname(), author.getPseudo())
                .orElseGet(() -> authorDao.save(author));
    }

    private PublisherEntity getOrCreatePublisher(PublisherEntity publisher){
        return publisherDao.findPublisherByName(publisher.getName())
                .orElseGet(() -> publisherDao.save(publisher));
    }

    private List<CategoryEntity> getOrCreateCategories(List<CategoryEntity> categories){
        return categories.stream()
                .map(category -> categoryDao.findByName(category.getName())
                                .orElseGet(() -> categoryDao.save(category)))
                .collect(Collectors.toList());
    }


}
