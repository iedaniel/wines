package com.hse.wines.model.dto;

import com.hse.wines.model.entity.Wine;
import com.hse.wines.model.entity.Winery;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class WineryDto {

    private String name;

    private List<Wine> wines;

    public WineryDto(Winery winery) {
        this.name = winery.getName();
        this.wines = winery.getWines();
    }
}
