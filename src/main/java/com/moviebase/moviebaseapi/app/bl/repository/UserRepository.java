package com.moviebase.moviebaseapi.app.bl.repository;

import com.moviebase.moviebaseapi.app.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByUsername(String username);
}
