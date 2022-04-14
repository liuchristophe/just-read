package com.csid.justread.book;

import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto entityToDto ( BookEntity b ) {
        BookDto result = new BookDto ();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        result.setIsbn( b.getIsbn() );
        result.setYear( b.getYear() );
        if ( b.getPublisher() != null ) result.setPublisher(PublisherMapper.entityToDto( b.getPublisher()));
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.entityToDto( b.getAuthor() ) );
        /* if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map(e -> EditionMapper.entityToEdition(e) ).collect(Collectors.toList()) ); */
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map(CategoryMapper::entityToDto).collect( Collectors.toList() ) );
        return result;
    }
    public static BookEntity dtoToEntity ( BookDto b ) {
        BookEntity result = new BookEntity ();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setId(b.getId());
        result.setIsbn( b.getIsbn() );
        result.setYear( b.getYear() );
        if ( b.getPublisher() != null ) result.setPublisher( PublisherMapper.dtoToEntity( b.getPublisher() ) );
        if ( b.getAuthor()   != null ) result.setAuthor( AuthorMapper.dtoToEntity( b.getAuthor() ) );
        /* if ( b.getEditions() != null ) result.setEditions( b.getEditions().stream().map(e -> EditionMapper.entityToEdition(e) ).collect(Collectors.toList()) ); */
        if ( b.getCategories() != null ) result.setCategories( b.getCategories().stream().map(CategoryMapper::dtoToEntity).collect( Collectors.toList() ) );
        return result;
    }
}
