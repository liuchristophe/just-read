package com.csid.justread.book.exposition.dto;

import java.util.UUID;

public class EditionDto {

    private UUID id;
    private String isbn;
    private int year;
    private PublisherDto publisher;
    // private Book book;

    //region * Methods *

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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

    public PublisherDto getPublisher() {
        return publisher;
    }
    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    //endregion
}
