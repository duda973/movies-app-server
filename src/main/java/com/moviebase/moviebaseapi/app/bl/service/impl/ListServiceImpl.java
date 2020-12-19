package com.moviebase.moviebaseapi.app.bl.service.impl;

import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.bl.service.ListService;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.User;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("listService")
public class ListServiceImpl implements ListService {

    private final ListRepository listRepository;
    private final UserProfileRepository userProfileRepository;

    public ListServiceImpl(ListRepository listRepository, UserProfileRepository userProfileRepository) {
        this.listRepository = listRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public MovieList create(MovieList movieList, String username) {
        movieList.setUser(userProfileRepository.findByUsername(username));

        return listRepository.save(movieList);
    }

    @Override
    public MovieList get(Integer id) {
        return listRepository.findById(id).orElse(null);
    }

    @Override
    public List<MovieList> findAll(String username) {
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        return listRepository.findAllByUser(userProfile);
    }
}
