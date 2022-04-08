package com.csid.justread.book;

import com.csid.justread.book.domain.model.Book;
import com.csid.justread.book.domain.model.Category;
import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.exposition.dto.CategoryDto;
import com.csid.justread.book.infrastructure.entity.BookEntity;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryDto categoryToDto(Category category) {
        CategoryDto result = new CategoryDto();
        result.setName(category.getName());
        result.setId(category.getId());
        return result;
    }

    public static Category dtoToCategory ( CategoryDto categoryDto )
    {
        Category result = new Category();
        result.setName(categoryDto.getName());
        result.setId(categoryDto.getId());
        return result;
    }

    public static Category entityToCategory(CategoryEntity categoryEntity) {

        Category result = new Category();
        result.setName(categoryEntity.getName());
        result.setId(categoryEntity.getId());
        return result;
    }

    public static CategoryEntity categoryToEntity(Category category) {

        CategoryEntity result = new CategoryEntity();
        result.setName(category.getName());
        result.setId(category.getId());
        return result;
    }
}
