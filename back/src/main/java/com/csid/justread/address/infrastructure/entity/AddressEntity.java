package com.csid.justread.address.infrastructure.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="address")
@Table (name="address")
public class AddressEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(length=100)
    private String streetName;

    @Column(length=100)
    private String complementaryField;

    @Column(length=100)
    private String zipCode;

    @Column(length=100)
    private String city;

    @Column(length=100)
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
