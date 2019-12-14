package com.hse.wines.model.dto;

import com.hse.wines.model.entity.Country;
import com.hse.wines.model.entity.Province;
import com.hse.wines.model.entity.Wine;

import java.util.List;

public class ProvinceDto {

    private String name;

    private Country country;

    private List<Wine> wines;

    public ProvinceDto(Province province) {
        this.name = province.getName();
        this.country = province.getCountry();
        this.wines = province.getWines();
    }
}
