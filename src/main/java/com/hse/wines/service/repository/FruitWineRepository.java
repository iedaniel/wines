package com.hse.wines.service.repository;

import com.hse.wines.model.entity.view.FrenchWine;
import com.hse.wines.model.entity.view.FruitWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitWineRepository extends JpaRepository<FruitWine, Long> {
}
