package com.csid.justread.book.exposition.dto;

/* Dto : BookCategory && Category */
public class CategoryDto {

    private long id;
    private String name;

    //region * Methods *
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
