package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.abstraction.GeneralEntity;
import com.moviebase.moviebaseapi.app.rest.model.IApiObject;

public interface IConverter<A extends IApiObject, D extends GeneralEntity> {
    A toDTO(D domainObj);
}
