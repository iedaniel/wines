package com.hse.wines.service.repository;

import com.hse.wines.model.entity.view.FrenchWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrenchWineRepository extends JpaRepository<FrenchWine, Long> {
}
