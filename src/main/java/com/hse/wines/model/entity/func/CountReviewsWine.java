package com.hse.wines.model.entity.func;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Immutable
@Entity
@Subselect(
        "SELECT wines.id                                          id,\n" +
                "       wines.title                                       title,\n" +
                "       count(reviews.id) over (partition BY wines.title) res\n" +
                "FROM wines\n" +
                "         JOIN reviews ON wines.id = reviews.wine_id\n"
)
public class CountReviewsWine {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "res")
    private Double res;
}
