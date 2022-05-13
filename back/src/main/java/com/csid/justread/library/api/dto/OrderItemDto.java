package com.csid.justread.library.api.dto;

import com.csid.justread.book.api.dto.BookDto;

import java.util.UUID;

public class OrderItemDto {
    private BookDto book;

    private int quantity;

    private float price;


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

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }
}
