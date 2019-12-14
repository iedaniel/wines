package com.hse.wines.service.repository;

import com.hse.wines.model.entity.func.CountWineriesCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountWineriesCountryRepository extends JpaRepository<CountWineriesCountry, Long> {
}
