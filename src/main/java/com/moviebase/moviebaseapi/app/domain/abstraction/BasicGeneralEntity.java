package com.moviebase.moviebaseapi.app.domain.abstraction;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class BasicGeneralEntity extends GeneralEntity<Integer> {
    @Id
    @GeneratedValue
    protected Integer id;

}
