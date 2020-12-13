package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.abstraction.GeneralEntity;
import com.moviebase.moviebaseapi.app.web.dto.IApiObject;

public interface IConverter<A extends IApiObject, D extends GeneralEntity> {
    A toDTO(D domainObj);
    D toDomain(A dtoObj);
}
