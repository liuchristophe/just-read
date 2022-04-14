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

        //Si l'auteur n'existe pas on le créer
        System.out.println(book.getAuthor().getId());
        if (book.getAuthor() != null) book.setAuthor(getOrCreateAuthor(book.getAuthor()));
        System.out.println(book.getAuthor().getId());
        //Si le publisher n'existe pas on le créer
        if (book.getPublisher() != null) book.setPublisher(getOrCreatePublisher(book.getPublisher()));

        //Si la catégorie n'existe pas on la crée
        if (book.getCategories() != null) book.setCategories(getOrCreateCategories(book.getCategories()));

        return BookMapper.entityToDto(bookDao.save(book));
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

        return this.bookDao.getAllBookByCategoriesName(categoryName)
                .stream()
                .map(b -> BookMapper.entityToDto(b))
                .collect(Collectors.toList());
    }


    public List<BookDto> getBooksByPublisherName(String publisherName) {

        return this.bookDao.getAllBookByPublisherName(publisherName)
                .stream()
                .map(b -> BookMapper.entityToDto(b))
                .collect(Collectors.toList());
    }


    public BookDto update(UUID id, BookEntity bookEntity) {
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

        System.out.println(bookEntity.getAuthor());

        return BookMapper.entityToDto(bookDao.save(result));
    }

    private AuthorEntity getOrCreateAuthor(AuthorEntity author){

        return authorDao.findAuthorByLastnameAndFirstnameAndPseudo(
                author.getLastname(), author.getFirstname(), author.getPseudo())
                .orElseGet(() -> authorDao.save(author));
    }

    private PublisherEntity getOrCreatePublisher(PublisherEntity publisher){
        return publisherDao.findPublisherByName(publisher.getName()).orElseGet(() -> publisherDao.save(publisher));
    }

    private List<CategoryEntity> getOrCreateCategories(List<CategoryEntity> categories){
        return categories.stream()
                .map(category -> categoryDao.findByName(category.getName())
                                .orElseGet(() -> categoryDao.save(category)))
                .collect(Collectors.toList());
    }
}
