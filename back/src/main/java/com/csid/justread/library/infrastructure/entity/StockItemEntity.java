package com.csid.justread.library.infrastructure.entity;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="stockItem")
@Table(name = "stock_item",uniqueConstraints = {@UniqueConstraint(columnNames = {"book_id", "libraryId", "unitPrice"})})
public class StockItemEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column()
    private int quantity;

    @Column()
    private int unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookEntity book;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="libraryId")
    private LibraryEntity library;

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

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public LibraryEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }
}
