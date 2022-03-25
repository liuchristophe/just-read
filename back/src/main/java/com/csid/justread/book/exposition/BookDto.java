package com.csid.justread.book.exposition;
import com.csid.justread.book.domain.model.Book;

public class BookDto {

    public BookDto() {}

    private long id;
    private String title;
    private String synopsys;
    private String author;

    // Todo : add edditions & categories

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //endregion

}
