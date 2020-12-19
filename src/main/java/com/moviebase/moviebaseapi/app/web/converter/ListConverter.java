package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.web.dto.ApiList;
import org.springframework.stereotype.Component;

@Component
public class ListConverter extends AbstractConverter<ApiList, MovieList> {

    @Override
    public ApiList toDTO(MovieList domainObj) {
        PrerequisiteUtil.notNull(domainObj, "List you have passed is null");

        return ApiList.builder()
                .name(domainObj.getName())
                .build();
    }

    @Override
    public MovieList toDomain(ApiList dtoObj) {
        PrerequisiteUtil.notNull(dtoObj, "List you have passed is null");

        MovieList obj = new MovieList();
        obj.setName(dtoObj.getName());

        return obj;
    }
}
