package com.hse.wines.service.repository;

import com.hse.wines.model.entity.Winery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineryRepository extends JpaRepository<Winery, Long>{
}
