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
@Table(name = "wineries")
public class Winery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "winery")
    private List<Wine> wines;
}
