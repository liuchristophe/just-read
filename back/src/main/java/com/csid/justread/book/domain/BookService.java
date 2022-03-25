package com.csid.justread.book.domain;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.infrastructure.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    public BookService(BookRepository br) { this.bookRepository = br; }
    private final BookRepository bookRepository;

    public Book create(Book book) {

        return this.bookRepository.save(book);

    }
}
