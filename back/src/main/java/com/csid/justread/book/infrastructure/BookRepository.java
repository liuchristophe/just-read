package com.csid.justread.book.infrastructure;

import com.csid.justread.book.domain.Book;
import com.csid.justread.book.infrastructure.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    private BookDao bookDao;

    public BookRepository(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save(Book book){

        //book doit être mapper en bookEntity
        //bookDao.save(book);
    }

}
