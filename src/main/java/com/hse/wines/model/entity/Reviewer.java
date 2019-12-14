package com.hse.wines.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Immutable
@Table(name = "reviewers")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "twitter_handle")
    private String handle;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reviewer")
    private List<Review> reviews;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "reviewers_regions",
            joinColumns = {@JoinColumn(name = "reviewer_id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id")}
    )
    private List<Region> regions;
}
