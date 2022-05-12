package com.csid.justread.library.api;

import com.csid.justread.Converter;
import com.csid.justread.book.api.dto.BookDto;
import com.csid.justread.book.service.model.Book;
import com.csid.justread.library.api.dto.StockCreationDto;
import com.csid.justread.library.api.dto.StockDto;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.service.LibraryService;
import com.csid.justread.library.service.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.csid.justread.library.service.model.Library;

@RestController()
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    //region * Library Management *

    @PostMapping()
    public LibraryDto createLibrary(@RequestBody LibraryDto libraryDto){
        return new Converter().map(
                libraryService.create(
                        new Converter().map(libraryDto, Library.class)
                ), LibraryDto.class);
    }
    @GetMapping()
    public List<LibraryDto> getLibraries(){
        List<Library> lib = libraryService.getLibraries();
        return new Converter().mapAsList(lib , LibraryDto.class);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<StockDto> getLibraryById( @PathVariable("uuid") UUID id ) {
        return ResponseEntity.ok(
                new Converter().map( this.libraryService.getLibraryById( id ).get(), StockDto.class)
        );
    }

    //endregion

    //region * Stock Management *

    @GetMapping("/stock")
    public List<StockDto> getStock () {
        return new Converter().mapAsList( this.libraryService.getStock(), StockDto.class);
    }

    @GetMapping("/stock/{uuid}")
    public ResponseEntity<StockDto> getStockById(@PathVariable("uuid") UUID id ) {
        return ResponseEntity.ok(
                new Converter().map( this.libraryService.getStockById( id ), StockDto.class )
        );
    }

    /** Todo : placer l'id library automatiquement pour la librairie en cours ... **/
    /*
    @PostMapping("/stock/{uuid}")
    public ResponseEntity<StockDto> createStock(@PathVariable("uuid") UUID idLibrary, @RequestBody StockCreationDto stock) {
        return ResponseEntity.ok(
                new Converter().map( this.libraryService.createStock(idLibrary, stock.getIdBooks()), StockDto.class )
        );
    }
    public Stock createStockTest(@PathVariable("uuid") UUID idLibrary, @RequestBody StockCreationDto stock) {
        return this.libraryService.createStockTest(idLibrary, stock.getIdBooks());
    }
    /**/

    //endregion
}
