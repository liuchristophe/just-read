package com.csid.justread.book.infrastructure;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.infrastructure.dao.BookDao;
import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    private BookDao bookDao;

    public BookRepository(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book save(Book book){
        //book doit être mapper en bookEntity
       return BookMapper.entityToBook(bookDao.save(BookMapper.bookToEntity(book)));
    }

}
