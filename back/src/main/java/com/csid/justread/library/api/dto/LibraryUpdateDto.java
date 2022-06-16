package com.csid.justread.library.api.dto;

import com.csid.justread.address.api.dto.AddressDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LibraryUpdateDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private AddressDto address;

    @JsonProperty("urlImage")
    private String urlImage;

    @JsonProperty("description")
    private String description;


    //region * Methods *

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //endregion

}
