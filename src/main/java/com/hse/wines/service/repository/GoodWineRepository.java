package com.hse.wines.service.repository;

import com.hse.wines.model.entity.view.GoodWine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodWineRepository extends JpaRepository<GoodWine, Long> {
}
