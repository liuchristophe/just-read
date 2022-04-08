package com.csid.justread.book.exposition.dto;

import java.util.List;
import java.util.UUID;

public class BookDto {

    public BookDto() {}

    private UUID id;
    private String title;
    private String synopsys;
    private AuthorDto author;
    private List<CategoryDto> categories;
    private List<EditionDto> editions;

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

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    public List<EditionDto> getEditions() {
        return editions;
    }

    public void setEditions(List<EditionDto> editions) {
        this.editions = editions;
    }

    //endregion

}
