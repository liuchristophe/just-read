package com.csid.justread.book.exposition;

import com.csid.justread.book.BookMapper;
import com.csid.justread.book.domain.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookController(BookService bs) { this.bookService = bs; }
    private final BookService bookService;

    //region * Book Management *

    @GetMapping("")
    public String getTest () {
        return "Get Method Works";
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook (@RequestBody BookDto bookDto) {
        return ResponseEntity.ok (
                BookMapper.bookToDto( this.bookService.create( BookMapper.dtoToBook( bookDto ) ) )
        );
    }

    //endregion

}
