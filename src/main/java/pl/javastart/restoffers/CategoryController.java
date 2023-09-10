package pl.javastart.restoffers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    private List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/api/categories/names")
    private List<String> getCategoriesNames() {
        return categoryService.getCategoriesNames();
    }

    @GetMapping("/api/categories/{id}")
    ResponseEntity<CategoryDto> getCagegoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("api/categories/{id}")
    private void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

