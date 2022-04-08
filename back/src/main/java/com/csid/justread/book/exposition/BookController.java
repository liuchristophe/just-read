package com.csid.justread.book.exposition;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.BookService;
import com.csid.justread.book.exposition.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookController(BookService bs) { this.bookService = bs; }
    private final BookService bookService;

    //region * Book Management *

    @GetMapping("")
    public List<BookDto> getBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BookDto> getBookById (@PathVariable("uuid") UUID id ) {
        return this.bookService.getBookById( id )
                .map( ResponseEntity::ok )
                .orElse( ResponseEntity.notFound().build() );
    }

    @GetMapping("/category/{categoryName}")
    public List<BookDto> getBooksByCategoryName (@PathVariable("categoryName") String categoryName){
        return bookService.getBooksByCategoryName(categoryName.trim());
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook (@RequestBody BookDto bookDto) {
        return ResponseEntity.ok ( this.bookService.create( BookMapper.dtoToBook( bookDto ) ) );
    }

    //endregion

}
