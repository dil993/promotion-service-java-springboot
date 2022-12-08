package com.sivalabs.bookstore.promotions.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    List<Promotion> findByIsbnIn(List<String> isbnList);
    Optional<Promotion> findByIsbn(String isbn);
}
