package com.csid.justread.book.domain;
import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    public BookService(BookRepository br) { this.bookRepository = br; }
    private final BookRepository bookRepository;

    public BookDto create(Book book) {
        return BookMapper.bookToDto( this.bookRepository.save( BookMapper.bookToEntity( book ) ) );
    }

    public List<BookDto> getBooks() {
        return this.bookRepository.getBooks().stream()
                .map( b -> BookMapper.bookToDto(b) )
                .collect(Collectors.toList());
    }

    public Optional<BookDto> getBookById(long id) {
        return this.bookRepository.getBookById( id ).map( b -> BookMapper.bookToDto( b ) );
    }

//    public List<Book> getBooksByCategoryName(String categoryName) {
//        return this.bookRepository.getBooksByCategoryName(categoryName);
//    }
}
