package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.rest.model.ApiList;
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
}
