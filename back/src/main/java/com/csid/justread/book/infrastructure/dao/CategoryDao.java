package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByName(String categoryName);
}
