package com.csid.justread.utilisateur.service.model;

import com.csid.justread.address.infrastructure.entity.AddressEntity;

import java.util.UUID;

public class Utilisateur {

    private UUID id;

    private String pseudo;

    private String email;

    private String password;

    private AddressEntity address;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
