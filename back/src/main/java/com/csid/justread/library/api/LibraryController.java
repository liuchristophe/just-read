package com.csid.justread.library.api;

import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.StockDto;
import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import com.csid.justread.library.service.model.Library;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/library")
public class LibraryController {

    private final LibraryService libraryService;
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

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

    @PatchMapping()
    public ResponseEntity updateStock() {
        return null; /** TODO : mises à jour de stock **/
    }

    //endregion



    @PostMapping()
    public LibraryDto create(@RequestBody LibraryDto libraryDto){
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
}
