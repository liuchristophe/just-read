package com.csid.justread.book.infrastructure.dao;

import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, UUID> {
    Optional<CategoryEntity> findByName(String categoryName);
}
