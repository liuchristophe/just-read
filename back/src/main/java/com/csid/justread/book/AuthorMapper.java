package com.csid.justread.book;

import com.csid.justread.book.exposition.dto.AuthorDto;
import com.csid.justread.book.infrastructure.entity.AuthorEntity;

public class AuthorMapper {

    public static AuthorEntity dtoToEntity ( AuthorDto a ) {
        AuthorEntity result = new AuthorEntity();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }
    public static AuthorDto entityToDto ( AuthorEntity a ) {
        AuthorDto result = new AuthorDto();
        result.setFirstname ( a.getFirstname () );
        result.setLastname  ( a.getLastname  () );
        result.setPseudo    ( a.getPseudo    () );
        result.setUrlWiki   ( a.getUrlWiki   () );
        result.setId(a.getId());
        return result;
    }

}
