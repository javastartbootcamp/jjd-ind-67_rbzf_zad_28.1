package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

@Service
public class OfferDtoMapper {

    private final CategoryRepository categoryRepository;

    public OfferDtoMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    OfferDto map(Offer offer) {
        OfferDto dto = new OfferDto();
        dto.setId(offer.getId());
        dto.setTitle(offer.getTitle());
        dto.setDescription(offer.getDescription());
        dto.setPrice(offer.getPrice());
        dto.setImgUrl(offer.getImgUrl());
        dto.setCategoryId(offer.getCategory().getId());
        dto.setCategoryName(offer.getCategory().getName());
        return dto;
    }

}
