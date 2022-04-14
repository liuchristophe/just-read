package com.csid.justread.book.exposition.dto;

import java.util.UUID;

public class CategoryDto {

    private UUID id;
    private String name;
    private Long bookCount;

    //region * Methods *
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }
    //endregion

}
