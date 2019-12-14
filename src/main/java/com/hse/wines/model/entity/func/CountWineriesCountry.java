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
        "SELECT countries.id                                    id,\n" +
                "       countries.name                                  name,\n" +
                "       count(w2.id) over (partition BY countries.name) res\n" +
                "FROM countries\n" +
                "         JOIN provinces p ON countries.id = p.country_id\n" +
                "         JOIN wines w ON p.id = w.province_id\n" +
                "         JOIN wineries w2 ON w.winery_id = w2.id\n"
)
public class CountWineriesCountry {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "res")
    private Double res;
}
