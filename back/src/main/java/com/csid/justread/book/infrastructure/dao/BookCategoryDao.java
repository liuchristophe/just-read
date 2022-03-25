package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.BookCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryDao extends JpaRepository<BookCategoryEntity, Long> {

}
