package com.csid.justread.book.service;

import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryRepository {

    private CategoryDao categoryDao;

    public CategoryRepository(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryEntity> getCategories() {
        return categoryDao.findAll();
    }
}
