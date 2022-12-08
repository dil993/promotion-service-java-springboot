package com.sivalabs.bookstore.promotions.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionRepository promotionRepository;

    public List<Promotion> getPromotions(List<String> isbnList) {
        return promotionRepository.findByIsbnIn(isbnList);
    }

    public Optional<Promotion> getPromotionByIsbn(String isbn) {
        return promotionRepository.findByIsbn(isbn);
    }
}
