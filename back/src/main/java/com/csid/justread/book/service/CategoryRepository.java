package com.csid.justread.book.service;

import com.csid.justread.book.Converter;
import com.csid.justread.book.api.dto.CategoryDto;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepository {

    private CategoryDao categoryDao;

    public CategoryRepository(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryEntity> getCategories() {
        return categoryDao.findAll();
    }
}
