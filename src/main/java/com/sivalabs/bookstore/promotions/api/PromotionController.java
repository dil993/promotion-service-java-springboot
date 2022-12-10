package com.sivalabs.bookstore.promotions.api;

import com.sivalabs.bookstore.promotions.domain.Promotion;
import com.sivalabs.bookstore.promotions.domain.PromotionService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping
    public List<Promotion> getPromotions(@RequestParam(name = "productCodes") String productCodes) {
        return promotionService.getPromotions(List.of(productCodes.split(",")));
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Promotion> getPromotionByCode(@PathVariable String productCode) {
        Promotion promotion =
                promotionService
                        .getPromotionByProductCode(productCode)
                        .orElse(new Promotion(null, productCode, BigDecimal.ZERO));
        return ResponseEntity.ok(promotion);
    }
}
