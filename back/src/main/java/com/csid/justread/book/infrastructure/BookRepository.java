package com.csid.justread.book.infrastructure;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.dao.AuthorDao;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.dao.EditionDao;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.EditionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookRepository {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private EditionDao editionDao;

    public BookRepository(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book save(BookEntity bookEntity){

        return BookMapper.entityToBook(bookDao.save( bookEntity ));
    }

    public List<Book> getBooks() {
        return this.bookDao.findAll().stream().map(
                b -> BookMapper.entityToBook(b)
        ).collect(Collectors.toList());
    }

    public Optional<Book> getBookById(long id) {
        return this.bookDao.findById( id ).map( b -> BookMapper.entityToBook( b ) );
    }

//    public List<BookDto> getBooksByCategoryName(String categoryName) {
//        return this.bookDao.getAllBookByCategoryName(categoryName);
//    }
}
