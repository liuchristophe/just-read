package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherDao extends JpaRepository<PublisherEntity, Long> {
}