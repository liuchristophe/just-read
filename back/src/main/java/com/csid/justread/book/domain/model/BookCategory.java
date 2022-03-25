package com.csid.justread.book.domain.model;

public class BookCategory {

    public BookCategory() {}

    private long id;
    private Category category;
    private Book book;

    //region * Methods *

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //endregion
}