package com.csid.justread.book.domain.model;

import java.util.UUID;

public class Category {

    public Category() {}

    private UUID id;
    private String name;

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

    //endregion

}