package com.csid.justread.book.exposition.dto;

public class AuthorDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String pseudo;
    private String urlWiki;

    //region * Methods *

    public Long getId() {
        return id;
    }
    public void setId(Long id) { this.id= id;}
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
