package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockItemDao;
import com.csid.justread.library.infrastructure.entity.StockItemEntity;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import com.csid.justread.library.service.model.StockItem;
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

    public List<StockItem> getStock(UUID libraryId) {
        LibraryEntity libraryEntity = this.libraryDao.getById(libraryId);
        if(libraryEntity==null) return null;
        return new Converter().mapAsList(libraryEntity.getStocks(), StockItem.class);
    }

    public StockItem addStockItem(UUID libraryId, StockItem stockItem){
        StockItemEntity stockItemEntity;
        if(stockItem==null) return null;
        if(stockItem.getBook() == null) return null;
        stockItemEntity=  new Converter().map(stockItem , StockItemEntity.class);
        stockItemEntity.setLibrary(libraryDao.findById(libraryId).orElse(null));
        stockItemEntity.setBook(bookDao.findById(stockItem.getBook().getId()).orElse(null));
        if(stockItemEntity.getLibrary()==null) return null;
        if(stockItemEntity.getBook()==null) return null;
        return new Converter().map( this.stockItemDao.save(stockItemEntity), StockItem.class);
    }

    public void deleteStockItem(UUID libraryId, UUID stockItemId){
        LibraryEntity library = libraryDao.findById(libraryId).orElse(null);
        StockItemEntity stockItemEntity;
        if(library == null) return;

        stockItemEntity=library.getStocks().stream()
                .filter(item -> item.getId().equals(stockItemId))
                .findFirst()
                .orElse(null);

        if(stockItemEntity==null) return;
        this.stockItemDao.delete(stockItemEntity);
    }

    public StockItem updateStockItem(UUID libraryId, UUID stockItemId, StockItem stockItem){
        LibraryEntity library = libraryDao.findById(libraryId).orElse(null);
        StockItemEntity stockItemEntity;
        if(library == null) return null;

        stockItemEntity=library.getStocks().stream()
                .filter(item -> item.getId().equals(stockItemId))
                .findFirst()
                .orElse(null);

        if(stockItemEntity==null) return null;

        stockItemEntity.setQuantity(stockItem.getQuantity());
        stockItemEntity.setUnitPrice(stockItem.getUnitPrice());
        return new Converter().map(this.stockItemDao.save(stockItemEntity), StockItem.class);
    }
}
