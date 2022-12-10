package com.sivalabs.bookstore.promotions.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:tc:postgresql:15-alpine:///dbname"})
class PromotionRepositoryTest {
    @Autowired private PromotionRepository promotionRepository;

    @BeforeEach
    void setUp() {
        promotionRepository.deleteAll();

        promotionRepository.save(new Promotion(null, "P100", BigDecimal.valueOf(2)));
        promotionRepository.save(new Promotion(null, "P101", BigDecimal.valueOf(4)));
    }

    @Test
    void shouldGetAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        assertThat(promotions).hasSize(2);
    }

    @Test
    void shouldGetPromotionByProductCode() {
        Optional<Promotion> optionalProduct = promotionRepository.findByProductCode("P100");
        assertThat(optionalProduct).isNotEmpty();
        assertThat(optionalProduct.get().getProductCode()).isEqualTo("P100");
        assertThat(optionalProduct.get().getDiscount()).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    void shouldGetPromotionByProductCodeList() {
        List<Promotion> promotions =
                promotionRepository.findByProductCodeIn(List.of("P100", "P101"));
        assertThat(promotions).hasSize(2);
    }
}
