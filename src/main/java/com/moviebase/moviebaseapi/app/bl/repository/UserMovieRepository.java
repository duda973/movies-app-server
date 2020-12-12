package com.moviebase.moviebaseapi.app.bl.repository;

import com.moviebase.moviebaseapi.app.domain.UserMovie;
import com.moviebase.moviebaseapi.app.domain.UserMovieKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieRepository extends CrudRepository<UserMovie, UserMovieKey> {

}
