package com.moviebase.moviebaseapi.app.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GeneralEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
