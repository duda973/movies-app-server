package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserMovie;
import com.moviebase.moviebaseapi.app.rest.model.ApiMovie;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.rest.model.ApiList;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ListConverter extends AbstractConverter<ApiList, MovieList> {

    private final MovieConverter movieConverter;

    public ListConverter(MovieConverter movieConverter) {
        this.movieConverter = movieConverter;
    }

    @Override
    public ApiList toDTO(MovieList domainObj) {
        PrerequisiteUtil.notNull(domainObj, "List you have passed is null");
        Set<ApiMovie> set = new HashSet<>();
        domainObj.getUserMovies()
                .stream()
                .map(UserMovie::getMovie)
                .map(movieConverter::toDTO)
                .forEach(set::add);

        return ApiList.builder()
                .name(domainObj.getName())
                .movies(set)
                .build();
    }
}
