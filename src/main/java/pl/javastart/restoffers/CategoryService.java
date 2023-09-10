package pl.javastart.restoffers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryDtoMapper categoryDtoMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryDtoMapper categoryDtoMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoMapper = categoryDtoMapper;
    }

    List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryDtoMapper::map).toList();
    }

    Optional<CategoryDto> getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryDtoMapper::map);
    }

    void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    List<String> getCategoriesNames() {
        List<String> categoriesNames = new ArrayList<>();
        for(Category category:categoryRepository.findAll()) {
            categoriesNames.add(category.getName());
        }
        return categoriesNames;
    }

}

