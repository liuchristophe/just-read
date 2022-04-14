package com.csid.justread.book;

import com.csid.justread.book.exposition.dto.PublisherDto;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;

public class PublisherMapper {

    public static PublisherDto entityToDto ( PublisherEntity p ) {
        PublisherDto result = new PublisherDto ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }
    public static PublisherEntity dtoToEntity ( PublisherDto p ) {
        PublisherEntity result = new PublisherEntity ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }

}
