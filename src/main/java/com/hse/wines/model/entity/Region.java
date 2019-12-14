package com.hse.wines.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Immutable
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "wines_regions",
            joinColumns = {@JoinColumn(name = "region_id")},
            inverseJoinColumns = {@JoinColumn(name = "wine_id")}
    )
    private List<Wine> wines;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reviewers_regions",
            joinColumns = {@JoinColumn(name = "region_id")},
            inverseJoinColumns = {@JoinColumn(name = "reviewer_id")}
    )
    private List<Reviewer> reviewers;
}
