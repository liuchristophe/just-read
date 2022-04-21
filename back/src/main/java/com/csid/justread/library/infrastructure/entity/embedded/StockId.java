package com.csid.justread.library.infrastructure.entity.embedded;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.List;

@Embeddable
public class StockId implements Serializable {

    /*
    @ManyToOne(  )
    */
    LibraryEntity library;

    /*
    @OneToMany( targetEntity = BookEntity.class )
    @JoinColumn(name = "***", referencedColumnName = "***")
    */
    List<BookEntity> bookList;

    //region * Methods *

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }

    public List<BookEntity> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }


    //endregion
}
