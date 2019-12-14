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
@Table(name = "wines")
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "designation")
    private String designation;

    @Column(name = "price")
    private Integer price;

    @Column(name = "variety")
    private String variety;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winery_id")
    private Winery winery;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    private List<Review> reviews;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "wines_regions",
            joinColumns = {@JoinColumn(name = "wine_id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id")}
    )
    private List<Region> regions;
}
