package com.moviebase.moviebaseapi.app.bl.service;

import com.moviebase.moviebaseapi.app.domain.List;

public interface ListService {

    List create(List list, String username);

    List get(Integer id);
}
