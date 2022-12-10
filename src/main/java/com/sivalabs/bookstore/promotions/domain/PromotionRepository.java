package com.sivalabs.bookstore.promotions.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByProductCodeIn(List<String> productCodes);

    Optional<Promotion> findByProductCode(String productCode);
}
