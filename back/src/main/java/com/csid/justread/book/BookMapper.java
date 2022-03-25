package com.csid.justread.book;
import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.domain.model.Category;
import com.csid.justread.book.exposition.BookDto;

import java.util.ArrayList;

public class BookMapper {
    public static BookDto createDto(Book b ) {
        BookDto result = new BookDto();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        result.setAuthor( b.getAuthor().getPseudo().toString() );
        return result;
    }

    public static Book createBook ( BookDto b )
    {
        Book result = new Book();
        result.setTitle( b.getTitle() );
        result.setSynopsys( b.getSynopsys() );
        // Todo : prise en charge author - categories - editions
        return result;
    }
}
