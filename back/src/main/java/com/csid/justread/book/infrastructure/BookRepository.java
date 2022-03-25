package com.csid.justread.book.infrastructure;

import com.csid.justread.book.infrastructure.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    private BookDao bookDao;

    public BookRepository(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
