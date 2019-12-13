package com.hse.wines.model.dto;

import com.hse.wines.model.entity.Review;
import com.hse.wines.model.entity.Reviewer;
import com.hse.wines.model.entity.Wine;

public class ReviewDto {

    private Reviewer reviewer;
    private Integer points;
    private String description;
    private Wine wine;

    public ReviewDto(Review review) {
        this.reviewer = review.getReviewer();
        this.points = review.getPoints();
        this.description = review.getDescription();
        this.wine = review.getWine();
    }
}
