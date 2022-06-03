package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.exception.ServiceException;
import com.csid.justread.library.api.dto.LibraryDto;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockItemDao;
import com.csid.justread.library.infrastructure.entity.StockItemEntity;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import com.csid.justread.library.service.model.StockItem;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class LibraryService {

    private final LibraryDao libraryDao;
    private final StockItemDao stockItemDao;
    private final BookDao bookDao;

    public LibraryService(LibraryDao libraryDao, StockItemDao stockItemDao, BookDao bookDao) {
        this.libraryDao = libraryDao;
        this.stockItemDao = stockItemDao;
        this.bookDao  = bookDao ;
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

    public Library getLibraryById( UUID id ) {
       return new Converter().map( this.libraryDao.getById( id ), Library.class );
    }

    public Library updateLibrary(UUID id, Library library) {
        Optional<Library> target = this.libraryDao.findById( id ).map( l -> new Converter().map(l, Library.class) );
        Library result = null;
        if ( target.isPresent() ) {
            target.map( t -> { t.update(library); return t; } );
            result = new Converter().map( this.libraryDao.save(
                        new Converter().map(target.get(), LibraryEntity.class)
            ), Library.class );
        }
        return result;
    }

    //endregion

    //region * Stock Management *

    public List<StockItem> getStock(UUID libraryId) {
        LibraryEntity libraryEntity = this.libraryDao.getById(libraryId);
        if(libraryEntity==null) return null;
        return new Converter().mapAsList(libraryEntity.getStocks(), StockItem.class);
    }

    public StockItem addStockItem(UUID libraryId, StockItem stockItem) throws ServiceException{
        StockItemEntity stockItemEntity;
        if(stockItem==null) throw new ServiceException("BadRequest", "StockItem null", HttpStatus.BAD_REQUEST);
        if(stockItem.getBook() == null) throw new ServiceException("BadRequest", "StockItem without book", HttpStatus.BAD_REQUEST);
        stockItemEntity=  new Converter().map(stockItem , StockItemEntity.class);
        stockItemEntity.setLibrary(libraryDao.findById(libraryId).orElse(null));
        stockItemEntity.setBook(bookDao.findById(stockItem.getBook().getId()).orElse(null));
        if(stockItemEntity.getLibrary()==null) throw new ServiceException("NotFound", "Library id: "+libraryId+" unknow", HttpStatus.NOT_FOUND);
        if(stockItemEntity.getBook()==null) throw new ServiceException("NotFound", "Book id: "+stockItem.getBook().getId()+" unknow", HttpStatus.NOT_FOUND);
        return new Converter().map( this.stockItemDao.save(stockItemEntity), StockItem.class);
    }

    public void deleteStockItem(UUID libraryId, UUID stockItemId) throws ServiceException{
        LibraryEntity library = libraryDao.findById(libraryId).orElse(null);
        StockItemEntity stockItemEntity;
        if(library == null) throw new ServiceException("NotFound", "Library id: "+libraryId+" unknow", HttpStatus.NOT_FOUND);

        stockItemEntity=library.getStocks().stream()
                .filter(item -> item.getId().equals(stockItemId))
                .findFirst()
                .orElse(null);

        if(stockItemEntity==null) throw new ServiceException("UNAUTHORIZED",
                "stockItem id: "+stockItemId+" unknow in library", HttpStatus.UNAUTHORIZED);
        this.stockItemDao.delete(stockItemEntity);
    }

    public StockItem updateStockItem(UUID libraryId, UUID stockItemId, StockItem stockItem){
        LibraryEntity library = libraryDao.findById(libraryId).orElse(null);
        StockItemEntity stockItemEntity;
        if(library == null) throw new ServiceException("NotFound", "Library id: "+libraryId+" unknow", HttpStatus.NOT_FOUND);

        stockItemEntity=library.getStocks().stream()
                .filter(item -> item.getId().equals(stockItemId))
                .findFirst()
                .orElse(null);

        if(stockItemEntity==null) throw new ServiceException("UNAUTHORIZED",
                "stockItem id: "+stockItemId+" unknow in library", HttpStatus.UNAUTHORIZED);

        stockItemEntity.setQuantity(stockItem.getQuantity());
        stockItemEntity.setUnitPrice(stockItem.getUnitPrice());
        return new Converter().map(this.stockItemDao.save(stockItemEntity), StockItem.class);
    }

    //endregion
}
