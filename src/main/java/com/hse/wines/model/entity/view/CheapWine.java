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
@Table(name = "cheap_wines")
public class CheapWine {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "points")
    private Integer points;
}
