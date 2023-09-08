package pl.javastart.restoffers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository, OfferRepository offerRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/categories")
    private List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @GetMapping("/api/categories/names")
    private List<String> getCategoriesNames() {
        List<String> categoriesNames = new ArrayList<>();
        for(Category category:categoryRepository.findAll()) {
            categoriesNames.add(category.getName());
        }
        return categoriesNames;
    }

    @DeleteMapping("api/categories/{id}")
    private void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
