package com.sivalabs.bookstore.promotions.api;

import com.sivalabs.bookstore.promotions.domain.Promotion;
import com.sivalabs.bookstore.promotions.domain.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping
    public List<Promotion> getPromotions(@RequestParam(name = "isbn") String isbnList) {
        return promotionService.getPromotions(List.of(isbnList.split(",")));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Promotion> getProductByCode(@PathVariable String isbn) {
        return promotionService.getPromotionByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
