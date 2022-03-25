package com.csid.justread.book.domain.model;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;

import java.util.List;

public class Book {

    public Book() {}

    private long id;
    private String title;
    private String synopsys;
    private Author author;
    private List<BookCategory> categories;
    private List<Edition> editions;

    //region * Methods *

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<BookCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<BookCategory> categories) {
        this.categories = categories;
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }

    //endregion

}
