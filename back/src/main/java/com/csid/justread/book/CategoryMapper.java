package com.csid.justread.book;

import com.csid.justread.book.exposition.dto.CategoryDto;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;

public class CategoryMapper {

    public CategoryDto entityToDto ( CategoryEntity c ) {
        CategoryDto result = new CategoryDto();
        result.setName(c.getName());
        result.setId(c.getId());
        return result;
    }
    public CategoryEntity dtoToEntity ( CategoryDto c ) {
        CategoryEntity result = new CategoryEntity();
        result.setName(c.getName());
        result.setId(c.getId());
        return result;
    }
}
