package com.hse.wines.service.repository;

import com.hse.wines.model.entity.view.CheapWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheapWineRepository extends JpaRepository<CheapWine, Long> {
}
