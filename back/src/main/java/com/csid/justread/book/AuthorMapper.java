package com.csid.justread.book;

import com.csid.justread.book.domain.model.Author;
import com.csid.justread.book.exposition.dto.AuthorDto;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;

public class AuthorMapper {

    public static AuthorDto authorToDto(Author a) {

        AuthorDto result = new AuthorDto();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }

    public static Author dtoToAuthor(AuthorDto a) {

        Author result = new Author();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }

    public static Author entityToAuthor(AuthorEntity a) {

        Author result = new Author();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }

    public static AuthorEntity authorToEntity(Author a) {

        AuthorEntity result = new AuthorEntity();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }
}
