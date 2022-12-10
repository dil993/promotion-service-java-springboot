package com.sivalabs.bookstore.promotions.domain;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    @Transactional(readOnly = true)
    public List<Promotion> getPromotions(List<String> productCodes) {
        return promotionRepository.findByProductCodeIn(productCodes);
    }

    @Transactional(readOnly = true)
    public Optional<Promotion> getPromotionByProductCode(String productCode) {
        return promotionRepository.findByProductCode(productCode);
    }
}
