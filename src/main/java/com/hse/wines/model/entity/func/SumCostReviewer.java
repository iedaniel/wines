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
        "SELECT reviewers.id                                  id,\n" +
                "       twitter_handle                                handle,\n" +
                "       SUM(price) OVER (PARTITION BY twitter_handle) money_spent\n" +
                "FROM (\n" +
                "         SELECT twitter_handle, r.price\n" +
                "         FROM reviewers\n" +
                "                  JOIN reviews r ON id = r.reviewer_id\n" +
                "     ) as thp\n" +
                "ORDER BY twitter_handle\n"
)
public class SumCostReviewer {

    @Id
    private Long id;

    @Column(name = "handle")
    private String handle;

    @Column(name = "res")
    private Double res;
}
