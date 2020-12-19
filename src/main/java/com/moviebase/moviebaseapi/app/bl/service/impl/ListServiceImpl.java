package com.moviebase.moviebaseapi.app.bl.service.impl;

import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.bl.service.ListService;
import com.moviebase.moviebaseapi.app.domain.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    public List create(List list, String username) {
        list.setUser(userProfileRepository.findByUsername(username));

        return listRepository.save(list);
    }

    @Override
    public List get(Integer id) {
        return listRepository.findById(id).orElse(null);
    }
}
