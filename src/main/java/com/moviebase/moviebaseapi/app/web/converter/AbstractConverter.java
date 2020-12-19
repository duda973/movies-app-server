package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.abstraction.GeneralEntity;
import com.moviebase.moviebaseapi.app.web.dto.IApiObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<A extends IApiObject, D extends GeneralEntity> implements IConverter<A, D> {

    public abstract A toDTO(D domainObj);

    public abstract D toDomain(A dtoObj);

    public List<A> toDTO(List<D> list) {
        List<A> result = new ArrayList<>();
        list.forEach(obj -> result.add(toDTO(obj)));
        return result;
    }

    public List<D> toDomain(List<A> list) {
        List<D> result = new ArrayList<>();
        list.forEach(obj -> result.add(toDomain(obj)));
        return result;
    }
}
