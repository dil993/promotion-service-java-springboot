package com.sivalabs.bookstore.promotions;

import com.sivalabs.bookstore.promotions.domain.Promotion;
import com.sivalabs.bookstore.promotions.domain.PromotionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PromotionRepository promotionRepository;

    public DataInitializer(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void run(String... args) {
        promotionRepository.deleteAll();

        promotionRepository.save(new Promotion(null, "P100", new BigDecimal("3.0")));
        promotionRepository.save(new Promotion(null, "P101", new BigDecimal("4.0")));
        promotionRepository.save(new Promotion(null, "P103", new BigDecimal("2.0")));

    }
}
