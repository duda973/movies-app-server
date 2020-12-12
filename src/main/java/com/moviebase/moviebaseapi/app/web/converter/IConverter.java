package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.abstraction.IGeneralEntity;
import com.moviebase.moviebaseapi.app.util.exception.AppException;
import com.moviebase.moviebaseapi.app.web.dto.IApiObject;

public interface IConverter<A extends IApiObject, D extends IGeneralEntity> {
    A toDTO(D domainObj) throws AppException;
    D toDomain(A dtoObj) throws AppException;
}
