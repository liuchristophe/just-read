package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockDao;
import com.csid.justread.library.service.model.Stock;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

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
}
