package com.csid.justread.book.infrastructure;

import com.csid.justread.book.CategoryMapper;
import com.csid.justread.book.exposition.dto.CategoryDto;
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

    public List<CategoryDto> getCategories() {
        return categoryDao.findAll()
                .stream()
                .map(CategoryMapper::entityToDto).collect(Collectors.toList());
    }
}
