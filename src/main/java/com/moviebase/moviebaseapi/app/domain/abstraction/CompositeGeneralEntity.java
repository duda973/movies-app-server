package com.moviebase.moviebaseapi.app.domain.abstraction;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@MappedSuperclass
public abstract class CompositeGeneralEntity<T extends Serializable> extends GeneralEntity<T> {
    @EmbeddedId
    protected T id;
}
