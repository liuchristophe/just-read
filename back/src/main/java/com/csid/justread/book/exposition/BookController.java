package com.csid.justread.book.exposition;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    public BookController(BookRepository br) { this.bookRepository = br; }
    private final BookRepository bookRepository;

    //region * Book Management *

    @GetMapping("")
    public List<BookDto> getBooks() {
        return this.bookRepository.getBooks();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BookDto> getBookById (@PathVariable("uuid") UUID id ) {
        return this.bookRepository.getBookById( id )
                .map( ResponseEntity::ok )
                .orElse( ResponseEntity.notFound().build() );
    }

    @GetMapping("/category/{categoryName}")
    public List<BookDto> getBooksByCategoryName (@PathVariable("categoryName") String categoryName){
        return bookRepository.getBooksByCategoryName(categoryName.trim());
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook (@RequestBody BookDto book) {
        return ResponseEntity.ok ( this.bookRepository.create(BookMapper.dtoToEntity(book) ));
    }

    //endregion

}
