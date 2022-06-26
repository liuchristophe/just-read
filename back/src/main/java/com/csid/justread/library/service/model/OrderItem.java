package com.csid.justread.library.service.model;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.service.model.Book;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

public class OrderItem {

    private Book book;

    private UUID id;

    private int quantity;

    private float price;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
