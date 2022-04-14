package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import com.csid.justread.book.infrastructure.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublisherDao extends JpaRepository<PublisherEntity, UUID> {

    @Query()
    Optional<PublisherEntity> findPublisherByName(String name);
}
