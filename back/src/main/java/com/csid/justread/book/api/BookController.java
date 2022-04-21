package com.csid.justread.book.api;

import com.csid.justread.Converter;
import com.csid.justread.book.api.dto.BookDto;
import com.csid.justread.book.service.BookTransactionnalService;
import com.csid.justread.book.service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    public BookController(BookTransactionnalService br) { this.bookRepository = br; }
    private final BookTransactionnalService bookRepository;

    //region * Book Management *

    @GetMapping("")
    public List<BookDto> getBooks() {
        System.out.println("convert en attente de création");
        Converter convert = new Converter();
        System.out.println("convert créée");
        return convert.mapAsList(this.bookRepository.getBooks(), BookDto.class);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BookDto> getBookById (@PathVariable("uuid") UUID id ) {
        return this.bookRepository.getBookById( id )
                .map(book -> ResponseEntity.ok(new Converter().map(book, BookDto.class)))
                .orElse( ResponseEntity.notFound().build() );
    }

    @GetMapping("/category/{categoryName}")
    public List<BookDto> getBooksByCategoryName (@PathVariable("categoryName") String categoryName){
        return new Converter().mapAsList(bookRepository.getBooksByCategoryName(categoryName.trim()), BookDto.class);
    }

    @GetMapping("/publisher/{publisherName}")
    public List<BookDto> getBooksByPublisherName (@PathVariable("publisherName") String publisherName){
        return new Converter().mapAsList(bookRepository.getBooksByPublisherName(publisherName.trim()), BookDto.class);
    }

    @GetMapping("/author/{authorID}")
    public List<BookDto> getBooksByAuthorID (@PathVariable("authorID") UUID id){
        return new Converter().mapAsList(bookRepository.getBooksByAuthorID(id), BookDto.class);
    }


    @PostMapping()
    public ResponseEntity<BookDto> create (@RequestBody BookDto book) {
        return ResponseEntity.ok ( new Converter().map(this.bookRepository.create(new Converter().map(book, Book.class)), BookDto.class));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDto> update (@PathVariable() UUID id,@RequestBody BookDto book){
        return ResponseEntity.ok(new Converter().map(this.bookRepository.update(id, new Converter().map(book, Book.class)), BookDto.class));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() UUID id){
        this.bookRepository.delete(id);
    }
    //endregion

}
