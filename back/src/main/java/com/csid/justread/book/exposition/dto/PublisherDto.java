package com.csid.justread.book.exposition.dto;

public class PublisherDto {

    public PublisherDto () {}

    private long id;
    private String name;

    //region * Methods *

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    //endregion

}
