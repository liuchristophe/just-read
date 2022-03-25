package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Long> {
}
