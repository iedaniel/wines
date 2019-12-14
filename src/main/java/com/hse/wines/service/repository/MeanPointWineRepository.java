package com.hse.wines.service.repository;

import com.hse.wines.model.entity.func.MeanPointWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeanPointWineRepository extends JpaRepository<MeanPointWine, Long> {
}
