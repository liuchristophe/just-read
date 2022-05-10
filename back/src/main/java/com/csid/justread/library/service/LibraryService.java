package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final LibraryDao libraryDao;

    public LibraryService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public Library create(Library library) {
        return new Converter().map(
                libraryDao.save(
                    new Converter().map(library, LibraryEntity.class)
                ), Library.class);
    }

    public List<Library> getLibraries(){
        return new Converter().mapAsList(libraryDao.findAll() , Library.class);
    }
}
