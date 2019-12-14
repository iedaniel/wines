package com.hse.wines.service.repository;

import com.hse.wines.model.entity.func.AvgWinery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvgWineryRepository extends JpaRepository<AvgWinery, Long> {
}
