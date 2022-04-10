package com.csid.justread.book.exposition;

import com.csid.justread.book.exposition.dto.BookDto;
import com.csid.justread.book.exposition.dto.CategoryDto;
import com.csid.justread.book.infrastructure.CategoryRepository;
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
        return this.categoryRepository.getCategories();
    }
}
