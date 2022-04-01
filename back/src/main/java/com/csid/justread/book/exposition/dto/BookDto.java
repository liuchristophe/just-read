package com.csid.justread.book.exposition.dto;

import java.util.List;

public class BookDto {

    public BookDto() {}

    private long id;
    private String title;
    private String synopsys;
    private AuthorDto author;
    private List<EditionDto> editions;


    // Todo : categories

    //region * Methods *


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<EditionDto> getEditions() {
        return editions;
    }

    public void setEditions(List<EditionDto> editions) {
        this.editions = editions;
    }

    //endregion

}
