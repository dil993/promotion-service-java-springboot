package com.sivalabs.bookstore.promotions;

import com.sivalabs.bookstore.promotions.domain.Promotion;
import com.sivalabs.bookstore.promotions.domain.PromotionRepository;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final PromotionRepository promotionRepository;

    public DataInitializer(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public void run(String... args) {
        if (promotionRepository.count() > 0) {
            log.info("Promotions already exists, skipping initialization");
            return;
        }
        promotionRepository.save(new Promotion(null, "P100", new BigDecimal("3.0")));
        promotionRepository.save(new Promotion(null, "P101", new BigDecimal("4.0")));
        promotionRepository.save(new Promotion(null, "P103", new BigDecimal("2.0")));

        log.info("Promotions initialized successfully");
    }
}
