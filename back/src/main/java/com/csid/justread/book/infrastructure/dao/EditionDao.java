package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.EditionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionDao extends JpaRepository<EditionEntity, Long> {
}
