package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockDao;
import com.csid.justread.library.service.model.Stock;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final LibraryDao libraryDao;
    private final StockDao   stockDao;
    public LibraryService(LibraryDao libraryDao, StockDao stockDao) {
        this.libraryDao = libraryDao;
        this.stockDao   = stockDao;
    }

    public List<Stock> getStock() {
        return new Converter().mapAsList( this.stockDao.findAll(), Stock.class );
    }

    public Stock getStockById( UUID id ) {
        return new Converter().map( this.stockDao.findById( id ), Stock.class );
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
