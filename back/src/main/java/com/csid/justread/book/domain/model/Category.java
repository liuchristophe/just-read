package com.csid.justread.book.domain.model;

public class Category {

    public Category() {}

    private int Id;
    private String name;

    //region * Methods *

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion

}