package com.csid.justread.book.infrastructure;

import com.csid.justread.book.CategoryMapper;
import com.csid.justread.book.domain.model.Category;
import com.csid.justread.book.infrastructure.dao.CategoryDao;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepository {

    private CategoryDao categoryDao;

    public CategoryRepository(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void save(Category category){
        categoryDao.save(CategoryMapper.categoryToEntity(category));
    }
}
