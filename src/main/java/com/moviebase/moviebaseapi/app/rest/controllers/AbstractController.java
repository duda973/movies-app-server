package com.moviebase.moviebaseapi.app.rest.controllers;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractController {

    @Autowired
    protected CommandDispatcher commandDispatcher;

    public UserDetails getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
