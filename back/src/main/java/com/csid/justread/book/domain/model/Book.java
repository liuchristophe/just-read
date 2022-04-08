package com.csid.justread.book.domain.model;

import java.util.List;
import java.util.UUID;

public class Book {

    public Book() {}

    private UUID id;
    private String title;
    private String synopsys;
    private Author author;
    private List<Edition> editions;
    private List<Category> categories;

    //region * Methods *

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public List<Edition> getEditions() {
        return editions;
    }
    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    //endregion

}
