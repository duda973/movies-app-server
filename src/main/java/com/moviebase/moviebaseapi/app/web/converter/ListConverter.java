package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.List;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.web.dto.ApiList;
import org.springframework.stereotype.Component;

@Component
public class ListConverter implements IConverter<ApiList, List> {

    @Override
    public ApiList toDTO(List domainObj) {
        PrerequisiteUtil.notNull(domainObj, "List you have passed is null");

        return ApiList.builder()
                .name(domainObj.getName())
                .build();
    }

    @Override
    public List toDomain(ApiList dtoObj) {
        PrerequisiteUtil.notNull(dtoObj, "List you have passed is null");

        List obj = new List();
        obj.setName(dtoObj.getName());

        return obj;
    }
}
