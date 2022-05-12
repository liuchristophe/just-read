package com.csid.justread.library.infrastructure.entity;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.library.service.model.Library;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity( name="stock" )
@Table ( name="stock" )
public class StockEntity {

    /*
    @EmbeddedId()
    private StockId id;
    */

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column()
    private int quantity;

    @Column()
    private int unitPrice;

    @JsonIgnore
    @OneToMany( targetEntity = BookEntity.class, fetch = FetchType.LAZY )
    private List<BookEntity> books;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private LibraryEntity library;

    //region * Methods *

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }

    //endregion

}
