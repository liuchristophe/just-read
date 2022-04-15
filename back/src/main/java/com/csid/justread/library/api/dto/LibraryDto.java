package com.csid.justread.library.api.dto;

import com.csid.justread.address.api.dto.AddressDto;
import com.csid.justread.address.service.model.Address;

import java.util.UUID;

public class LibraryDto {

    private UUID id;

    private String name;

    private AddressDto address;

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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
