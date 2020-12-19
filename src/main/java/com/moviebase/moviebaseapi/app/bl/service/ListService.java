package com.moviebase.moviebaseapi.app.bl.service;

import com.moviebase.moviebaseapi.app.domain.MovieList;

import java.util.List;

public interface ListService {

    MovieList create(MovieList movieList, String username);

    MovieList get(Integer id);

    List<MovieList> findAll(String username);
}
