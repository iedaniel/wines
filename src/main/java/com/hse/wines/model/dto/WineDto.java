package com.hse.wines.model.dto;

import com.hse.wines.model.entity.Province;
import com.hse.wines.model.entity.Region;
import com.hse.wines.model.entity.Wine;
import com.hse.wines.model.entity.Winery;

import java.util.List;

public class WineDto {

    private String title;

    private Integer price;

    private String variety;

    private Province province;

    private Winery winery;

    private List<Region> regions;

    public WineDto(Wine wine) {
        this.title = wine.getTitle();
        this.price = wine.getPrice();
        this.variety = wine.getVariety();
        this.province = wine.getProvince();
        this.winery = wine.getWinery();
        this.regions = wine.getRegions();
    }
}
