package com.moviebase.moviebaseapi.app.rest.controllers;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandDispatcher;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractController {

    @Autowired
    protected CommandDispatcher commandDispatcher;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserDetails getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    public UserProfile getUserProfile() {
        return userProfileRepository.findByUsername(getPrincipal().getUsername());
    }
}
