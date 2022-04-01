package com.csid.justread.book;

import com.csid.justread.book.domain.model.Publisher;
import com.csid.justread.book.exposition.dto.PublisherDto;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;

public class PublisherMapper {

    public static Publisher dtoToPublisher(PublisherDto p) {

        Publisher result = new Publisher ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }

    public static PublisherDto publisherToDto(Publisher p) {

        PublisherDto result = new PublisherDto ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }

    public static Publisher entityToPublisher(PublisherEntity p) {

        Publisher result = new Publisher ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }

    public static PublisherEntity publisherToEntity(Publisher p) {

        PublisherEntity result = new PublisherEntity ();
        result.setId( p.getId() );
        result.setName( p.getName() );
        return result;
    }
}
