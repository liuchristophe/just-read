package com.csid.justread.book;

import com.csid.justread.book.domain.model.Edition;
import com.csid.justread.book.exposition.dto.EditionDto;
import com.csid.justread.book.infrastructure.entity.EditionEntity;

public class EditionMapper {
    public static Edition dtoToEdition(EditionDto e) {

        Edition result = new Edition();
        result.setId( e.getId() );
        result.setIsbn( e.getIsbn() );
        result.setYear( e.getYear() );
        if ( e.getPublisher() != null ) result.setPublisher( PublisherMapper.dtoToPublisher( e.getPublisher() ) );
        return result;
    }

    public static EditionDto editionToDto(Edition e) {

        EditionDto result = new EditionDto();
        result.setId( e.getId() );
        result.setIsbn( e.getIsbn() );
        result.setYear( e.getYear() );
        if ( e.getPublisher() != null ) result.setPublisher( PublisherMapper.publisherToDto( e.getPublisher() ) );
        return result;
    }

    public static Edition entityToEdition(EditionEntity e) {

        Edition result = new Edition();
        result.setId( e.getId() );
        result.setIsbn( e.getIsbn() );
        result.setYear( e.getYear() );
        if ( e.getPublisher() != null ) result.setPublisher( PublisherMapper.entityToPublisher( e.getPublisher() ) );
        return result;
    }

    public static EditionEntity editionToEntity(Edition e) {

        EditionEntity result = new EditionEntity();
        result.setId( e.getId() );
        result.setIsbn( e.getIsbn() );
        result.setYear( e.getYear() );
        if ( e.getPublisher() != null ) result.setPublisher( PublisherMapper.publisherToEntity( e.getPublisher() ) );
        return result;
    }
}
