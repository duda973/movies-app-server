package com.moviebase.moviebaseapi.app.bl.repository;

import com.moviebase.moviebaseapi.app.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
