package pl.javastart.restoffers;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final OfferDtoMapper offerDtoMapper;

    public OfferService(OfferRepository offerRepository, OfferDtoMapper offerDtoMapper) {
        this.offerRepository = offerRepository;
        this.offerDtoMapper = offerDtoMapper;
    }

    List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map(offerDtoMapper::map).toList();
    }

    Optional<OfferDto> getOfferById(Long id) {
        return offerRepository.findById(id).map(offerDtoMapper::map);
    }

    Long countAllOffers() {
        return offerRepository.count();
    }

    void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

}
