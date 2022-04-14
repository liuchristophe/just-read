package com.csid.justread.book;

import com.csid.justread.book.exposition.dto.CategoryDto;
import com.csid.justread.book.infrastructure.entity.CategoryEntity;

public class CategoryMapper {

    public static CategoryDto entityToDto ( CategoryEntity c ) {
        CategoryDto result = new CategoryDto();
        result.setName(c.getName());
        result.setId(c.getId());
        result.setBookCount(c.getBookCount());
        return result;
    }
    public static CategoryEntity dtoToEntity ( CategoryDto c ) {
        CategoryEntity result = new CategoryEntity();
        result.setName(c.getName());
        result.setId(c.getId());
        result.setBookCount(c.getBookCount());
        return result;
    }
}
