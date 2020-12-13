package com.moviebase.moviebaseapi.app.domain.abstraction;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class SimpleGeneralEntity extends GeneralEntity<Integer> {
    @Id
    @GeneratedValue
    protected Integer id;

}
