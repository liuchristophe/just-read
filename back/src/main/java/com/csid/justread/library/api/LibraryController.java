package com.csid.justread.library.api;

import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.api.dto.StockItemDto;
import com.csid.justread.library.service.LibraryService;
import com.csid.justread.library.service.model.StockItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<LibraryDto> getLibraryById( @PathVariable("uuid") UUID id ) {
        return ResponseEntity.ok(
                new Converter().map( this.libraryService.getLibraryById( id ), LibraryDto.class)
        );
    }

    @GetMapping("/{libraryId}/stock")
    public ResponseEntity<List<StockItemDto>> getStock(@PathVariable("libraryId") UUID libraryId){
        return ResponseEntity.ok(new Converter().mapAsList(libraryService.getStock(libraryId), StockItemDto.class));
    }

    @PostMapping("/{libraryId}/stock/add")
    public ResponseEntity<StockItemDto> addStockItem(@PathVariable("libraryId") UUID libraryId,@RequestBody StockItemDto stockItemDto){
        StockItemDto result = new Converter()
                .map(libraryService.addStockItem(libraryId,
                        new Converter().map(stockItemDto, StockItem.class)
                ), StockItemDto.class);
        if(result == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{libraryId}/stock/remove/{stockItemId}")
    public void deleteStockItem(@PathVariable("libraryId") UUID libraryId,@PathVariable("stockItemId") UUID stockItemId){
        libraryService.deleteStockItem(libraryId, stockItemId);
    }

    @PatchMapping("{libraryId}/stock/remove/{stockItemId}")
    public ResponseEntity<StockItemDto> deleteStockItem(@PathVariable("libraryId") UUID libraryId,
                                @PathVariable("stockItemId") UUID stockItemId,
                                @RequestParam StockItemDto stockItemDto){
        StockItemDto result = new Converter()
                .map(libraryService.updateStockItem(libraryId, stockItemId,
                        new Converter().map(stockItemDto, StockItem.class)
                ), StockItemDto.class);

        if(result == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(result);
    }
}
