package com.csid.justread.book.api;

import com.csid.justread.book.Converter;
import com.csid.justread.book.api.dto.CategoryDto;
import com.csid.justread.book.service.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/Categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public List<CategoryDto> getCategories() {
        return new Converter().mapAsList(this.categoryRepository.getCategories(), CategoryDto.class);
    }
}
