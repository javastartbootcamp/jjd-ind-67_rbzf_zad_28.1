package pl.javastart.restoffers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class OfferController {
    private final OfferRepository offerRepository;

    public OfferController(OfferRepository offerRepository, CategoryRepository categoryRepository) {
        this.offerRepository = offerRepository;
    }
    @GetMapping("/api/offers")
    private List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @GetMapping("/api/offers/count")
    private Long countAllOffers() {
        return offerRepository.count();
    }

    @GetMapping("/api/offers/{id}")
    private Offer getOfferById(@PathVariable Long id) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        return offerOptional.orElseThrow();
    }

    @PostMapping("/api/offers")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        if (offer.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        offerRepository.save(offer);
        return ResponseEntity.ok(offer);
    }

    @DeleteMapping("/api/offers/{id}")
    private void deleteOffer(@PathVariable Long id) {
        offerRepository.deleteById(id);
    }
}
