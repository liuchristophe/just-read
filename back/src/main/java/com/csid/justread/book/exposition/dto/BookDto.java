package com.csid.justread.book.exposition.dto;
import com.csid.justread.book.domain.model.Book;

public class BookDto {

    public BookDto() {}

    private long id;
    private String title;
    private String synopsys;
    private AuthorDTO author;


    // Todo : add edditions & categories

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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    //endregion

}
