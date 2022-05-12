package com.csid.justread.library.service;

import com.csid.justread.Converter;
import com.csid.justread.book.infrastructure.dao.BookDao;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.service.model.Book;
import com.csid.justread.library.infrastructure.dao.LibraryDao;
import com.csid.justread.library.infrastructure.dao.StockDao;
import com.csid.justread.library.infrastructure.entity.StockEntity;
import com.csid.justread.library.service.model.Stock;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import com.csid.justread.library.service.model.Library;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class LibraryService {

    private final LibraryDao libraryDao;
    private final StockDao   stockDao;
    private final BookDao bookDao;

    public LibraryService(LibraryDao libraryDao, StockDao stockDao, BookDao bookDao) {
        this.libraryDao = libraryDao;
        this.stockDao = stockDao;
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

    public Stock createStock( UUID idLibrary, List<UUID> idBooks ) {

        /** Créer le stock **/
        Stock stock = new Stock();
        Optional<Library> library = this.libraryDao.findById( idLibrary ).map( l -> new Converter().map( l, Library.class ) );
        List<Book> bookList = new ArrayList<Book>();

        if (library.isPresent()) {
            Optional<BookEntity> book;
            stock.setLibrary( library.get() );

            for ( UUID id : idBooks ) {

                /** Vérifier que le livre existe **/
                book = this.bookDao.findById(id);
                book.ifPresent(bookEntity -> bookList.add(new Converter().map(bookEntity, Book.class)));
            }

            /** Ajouter les livres au stock et save **/
            stock.setBooks( bookList );
            StockEntity stockEntity = this.stockDao.save( new Converter().map( stock, StockEntity.class ) );
            stock = new Converter().map(
                    stockEntity, Stock.class
            );
        }
        return stock;
    }

    public Stock createStockTest(UUID idLibrary, List<UUID> idBooks) {

        List<Book> bookList = new ArrayList<Book>();
        Optional<Library> library = this.libraryDao.findById( idLibrary ).map( l -> new Converter().map( l, Library.class ) );
        Optional<BookEntity> book;
        Stock s = new Stock();

        if (library.isPresent()) {

            for (UUID id : idBooks) {
                book = this.bookDao.findById(id);
                book.ifPresent(bookEntity -> bookList.add(new Converter().map(bookEntity, Book.class)));
            }

            s.setBooks(bookList);
            if (library.isPresent()) s.setLibrary(library.get());

            StockEntity stockToSave = new Converter().map( s ,  StockEntity.class );
            stockToSave = this.stockDao.save(stockToSave);
            s = new Converter().map(stockToSave , Stock.class );

        }

        return s;
    }

    //endregion

}
