package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity, Long> {
}
