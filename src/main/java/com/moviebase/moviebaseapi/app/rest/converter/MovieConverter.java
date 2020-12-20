package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.Movie;
import com.moviebase.moviebaseapi.app.rest.model.ApiMovie;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends AbstractConverter<ApiMovie, Movie> {

    @Override
    public ApiMovie toDTO(Movie domainObj) {
        PrerequisiteUtil.notNull(domainObj, "Movie you have passed is null");

        return ApiMovie.builder()
                .name(domainObj.getName())
                .apiKey(domainObj.getApiId())
                .build();
    }
}
