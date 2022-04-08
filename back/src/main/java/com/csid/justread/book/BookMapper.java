package com.csid.justread.book;

import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto bookToDto(Book b ) {

        BookDto result = new BookDto();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.authorToDto( b.getAuthor() ) );
        if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map( e -> EditionMapper.editionToDto(e) ).collect(Collectors.toList()) );
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map( c -> CategoryMapper.categoryToDto(c) ).collect( Collectors.toList() ) );
        return result;
    }

    public static Book dtoToBook ( BookDto b ) {

        Book result = new Book();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.dtoToAuthor( b.getAuthor() ) );
        if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map(e -> EditionMapper.dtoToEdition(e) ).collect(Collectors.toList()) );
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map( c -> CategoryMapper.dtoToCategory(c) ).collect( Collectors.toList() ) );
        return result;
    }

    public static Book entityToBook(BookEntity b) {

        Book result = new Book();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.entityToAuthor( b.getAuthor() ) );
        if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map(e -> EditionMapper.entityToEdition(e) ).collect(Collectors.toList()) );
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map( c -> CategoryMapper.entityToCategory(c) ).collect( Collectors.toList() ) );
        return result;
    }

    public static BookEntity bookToEntity(Book b) {

        BookEntity result = new BookEntity();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.authorToEntity( b.getAuthor() ) );
        if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map(e -> EditionMapper.editionToEntity(e) ).collect(Collectors.toList()) );
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map( c -> CategoryMapper.categoryToEntity(c) ).collect( Collectors.toList() ) );
        return result;
    }
}
