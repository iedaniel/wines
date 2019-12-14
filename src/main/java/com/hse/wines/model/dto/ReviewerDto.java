package com.hse.wines.model.dto;

import com.hse.wines.model.entity.Region;
import com.hse.wines.model.entity.Review;
import com.hse.wines.model.entity.Reviewer;

import javax.persistence.*;
import java.util.List;

public class ReviewerDto {

    private String handle;

    private String name;

    private List<Region> regions;

    public ReviewerDto(Reviewer reviewer) {
        this.handle = reviewer.getHandle();
        this.name = reviewer.getName();
        this.regions = reviewer.getRegions();
    }
}
