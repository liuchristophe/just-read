package com.csid.justread.book.exposition.dto;

import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.domain.model.Publisher;

public class EditionDto {

    private long id;
    private String isbn;
    private int year;
    private Book book;
    private Publisher publisher;

    //region * Methods *

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    //endregion
}
