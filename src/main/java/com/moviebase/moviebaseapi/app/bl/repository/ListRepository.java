package com.moviebase.moviebaseapi.app.bl.repository;

import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends CrudRepository<MovieList, Integer> {

    List<MovieList> findAllByUser(UserProfile userProfile);
}
