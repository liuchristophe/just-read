package com.csid.justread.book.domain.model;

import java.util.UUID;

public class Edition {

    public Edition() {}

    private UUID id;
    private String isbn;
    private int year;
    private Publisher publisher;
    // private Book book;

    //region * Methods *

    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /*
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    */

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    //endregion
}
