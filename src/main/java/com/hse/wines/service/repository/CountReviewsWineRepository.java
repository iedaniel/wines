package com.hse.wines.service.repository;

import com.hse.wines.model.entity.func.CountReviewsWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountReviewsWineRepository extends JpaRepository<CountReviewsWine, Long> {
}
