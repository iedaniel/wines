package com.hse.wines.model.entity.view;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Immutable
@Entity
@Table(name = "vossroger_reviews")
public class Vossroger {

    @Id
    private Long id;

    @Column(name = "wine")
    private String wine;

    @Column(name = "description")
    private String description;

    @Column(name = "points")
    private Integer points;
}
