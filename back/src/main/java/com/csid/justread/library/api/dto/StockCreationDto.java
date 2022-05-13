package com.csid.justread.library.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class StockCreationDto {

    @JsonProperty("idBooks")
    List<UUID> idBooks;

    //region * Methods *

    public List<UUID> getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(List<UUID> idBooks) {
        this.idBooks = idBooks;
    }

    //endregion

}
