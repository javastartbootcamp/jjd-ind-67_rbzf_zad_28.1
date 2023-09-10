package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

@Service
public class CategoryDtoMapper {
    CategoryDto map(Category category) {
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dto.setDescription(category.getDescription());
            dto.setOffers(category.getOffers().size());
            return dto;
    }
}

