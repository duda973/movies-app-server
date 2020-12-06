package com.moviebase.moviebaseapi.app.bl.repository;

import com.moviebase.moviebaseapi.app.domain.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

}
