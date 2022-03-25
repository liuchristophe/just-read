package com.csid.justread.book.domain.model;


public class Publisher {

    public Publisher () {}

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

    //endregion

}
