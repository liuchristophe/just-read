package com.csid.justread.library.service.model;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.library.infrastructure.entity.LibraryEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

public class StockItem {

    private UUID id;

    private int quantity;

    private int unitPrice;

    private BookEntity book;


   // ---------------



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
}
