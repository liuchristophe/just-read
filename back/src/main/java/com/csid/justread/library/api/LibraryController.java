package com.csid.justread.library.api;

import com.csid.justread.Converter;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.service.LibraryService;
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
