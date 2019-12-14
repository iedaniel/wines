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
        "SELECT wines.id                                              id,\n" +
                "       wines.title                                           title,\n" +
                "       sum(points) / count(r.id) over (partition BY wine_id) res\n" +
                "FROM wines\n" +
                "         JOIN reviews r ON wines.id = r.wine_id\n"
)
public class MeanPointWine {

    @Id
    private Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "res")
    private Double res;
}
