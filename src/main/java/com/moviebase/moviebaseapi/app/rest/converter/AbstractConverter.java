package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.abstraction.GeneralEntity;
import com.moviebase.moviebaseapi.app.rest.model.IApiObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<A extends IApiObject, D extends GeneralEntity> implements IConverter<A, D> {

    public abstract A toDTO(D domainObj);

    public List<A> toDTO(List<D> list) {
        List<A> result = new ArrayList<>();
        list.forEach(obj -> result.add(toDTO(obj)));
        return result;
    }
}
