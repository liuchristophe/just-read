package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookDao extends JpaRepository<BookEntity, UUID> {
    List<BookEntity> getAllBookByCategories(CategoryEntity categoryEntity);
}
