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
        result.setAuthor( AuthorMapper.authorToDto( b.getAuthor() ) );
        result.setEditions(
                b.getEditions().stream().map( e -> EditionMapper.editionToDto(e) ).collect(Collectors.toList())
        );
        return result;
    }

    public static Book dtoToBook ( BookDto b )
    {
        Book result = new Book();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setAuthor( AuthorMapper.dtoToAuthor( b.getAuthor() ) );
        result.setEditions(
                b.getEditions().stream().map(e -> EditionMapper.dtoToEdition(e) ).collect(Collectors.toList())
        );
        // Todo : prise en charge - categories
        return result;
    }

    public static Book entityToBook(BookEntity book) {

        Book result = new Book();
        result.setTitle( book.getTitle() );
        result.setSynopsys( book.getSynopsys() );
        result.setAuthor( AuthorMapper.entityToAuthor( book.getAuthor() ) );
        result.setEditions(
                book.getEditions().stream().map(e -> EditionMapper.entityToEdition(e) ).collect(Collectors.toList())
        );
        // Todo : prise en charge - categories
        return result;
    }

    public static BookEntity bookToEntity(Book book) {

        BookEntity result = new BookEntity();
        result.setTitle( book.getTitle() );
        result.setSynopsys( book.getSynopsys() );
        result.setAuthor( AuthorMapper.authorToEntity( book.getAuthor() ) );
        result.setEditions(
                book.getEditions().stream().map(e -> EditionMapper.editionToEntity(e) ).collect(Collectors.toList())
        );
        // Todo : prise en charge author - categories
        return result;
    }
}
