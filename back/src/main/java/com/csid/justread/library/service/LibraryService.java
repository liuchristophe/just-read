package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockDao;
import com.csid.justread.library.infrastructure.entity.StockEntity;
import com.csid.justread.library.service.model.Stock;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

    //region * Library Management *

    public Library create(Library library) {
        return new Converter().map(
                libraryDao.save(
                        new Converter().map(library, LibraryEntity.class)
                ), Library.class);
    }

    public List<Library> getLibraries(){
        return new Converter().mapAsList(libraryDao.findAll() , Library.class);
    }

    public Optional<Library> getLibraryById( UUID id ) {
        Library l = new Converter().map( this.libraryDao.findById( id ), Library.class );
        return Optional.of(l);
    }

    //endregion

    //region * Stock Management *

    public List<Stock> getStock() {
        return new Converter().mapAsList( this.stockDao.findAll(), Stock.class );
    }

    public Optional<Stock> getStockById( UUID id ) {
        Stock s  = new Converter().map( this.stockDao.findById( id ), Stock.class );
        return Optional.of(s);
    }

    public Stock createStock( UUID idLibrary, Stock stock ) {

        Optional<Stock> optStock = ( stock.getId() != null ) ? this.getStockById( stock.getId() ) : Optional.empty();
        Optional<Library> optLibrary = this.getLibraryById( idLibrary );

        Stock   s = null;

        if ( optLibrary.isPresent() ) {

            if (optStock.isPresent()) {
                s = optStock.get();
                s.setLibrary( optLibrary.get() );
                s = new Converter().map( this.stockDao.save( new Converter().map( s, StockEntity.class) ), Stock.class );
            }
        }

        return  s;
    }

    //endregion

}
