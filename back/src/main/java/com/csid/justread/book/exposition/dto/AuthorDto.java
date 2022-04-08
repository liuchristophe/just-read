package com.csid.justread.book.exposition.dto;

import java.util.UUID;

public class AuthorDto {

    private UUID id;
    private String firstname;
    private String lastname;
    private String pseudo;
    private String urlWiki;

    //region * Methods *

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) { this.id= id;}
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getUrlWiki() {
        return urlWiki;
    }
    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }

    //endregion

}
