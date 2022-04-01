package com.csid.justread.book;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.domain.model.Category;
import com.csid.justread.book.exposition.BookDto;
import com.csid.justread.book.infrastructure.entity.BookEntity;

import java.util.ArrayList;

public class BookMapper {
    public static BookDto bookToDto(Book b ) {
        BookDto result = new BookDto();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        //result.setAuthor( b.getAuthor().getPseudo().toString() );
        return result;
    }

    public static Book dtoToBook ( BookDto b )
    {
        Book result = new Book();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        //result.setAuthor(b.getAuthor());
        // Todo : prise en charge author - categories - editions
        return result;
    }

    public static Book entityToBook(BookEntity book) {

        Book result = new Book();
        result.setTitle( book.getTitle() );
        result.setSynopsys( book.getSynopsys() );
        // Todo : prise en charge author - categories - editions
        return result;
    }

    public static BookEntity bookToEntity(Book book) {

        BookEntity result = new BookEntity();
        result.setTitle( book.getTitle() );
        result.setSynopsys( book.getSynopsys() );
        // Todo : prise en charge author - categories - editions
        return result;
    }
}
