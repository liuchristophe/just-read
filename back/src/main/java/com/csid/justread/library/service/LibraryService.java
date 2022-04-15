package com.csid.justread.library.service;

import com.csid.justread.library.infrastructure.dao.LibraryDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LibraryService {

    private final LibraryDao libraryDao;

    public LibraryService(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }
}
