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
        "SELECT wineries.id                                              id,\n" +
                "       wineries.name                                            name,\n" +
                "       sum(price) / count(w.id) over (partition BY wineries.id) res\n" +
                "FROM wineries\n" +
                "         JOIN wines w ON wineries.id = w.winery_id\n"
)
public class AvgWinery {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "res")
    private Double res;
}
