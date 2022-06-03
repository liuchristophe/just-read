package com.csid.justread.library.api.dto;

import com.csid.justread.address.api.dto.AddressDto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LibraryUpdateDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private AddressDto address;

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


    //endregion

}
