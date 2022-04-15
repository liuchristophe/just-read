package com.csid.justread.address.api.dto;

import java.util.UUID;

public class AddressDto {

    private UUID id;
    private String streetName;
    private String complementaryField;
    private String zipCode;
    private String city;
    private String country;

    //region * Methods *

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getComplementaryField() {
        return complementaryField;
    }

    public void setComplementaryField(String complementaryField) {
        this.complementaryField = complementaryField;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //endregion

}
