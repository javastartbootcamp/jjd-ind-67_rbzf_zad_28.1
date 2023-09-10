package pl.javastart.restoffers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/api/offers")
    private List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/api/offers/count")
    private Long countAllOffers() {
        return offerService.countAllOffers();
    }

    @GetMapping("/api/offers/{id}")
    private ResponseEntity<OfferDto> getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/offers/{id}")
    private void deleteOfferDto(@PathVariable Long id) {
        offerService.deleteOffer(id);
    }
}
