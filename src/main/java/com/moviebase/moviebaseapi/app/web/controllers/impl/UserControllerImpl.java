package com.moviebase.moviebaseapi.app.web.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.service.UserService;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.web.controllers.UserController;
import com.moviebase.moviebaseapi.app.web.converter.UserConverter;
import com.moviebase.moviebaseapi.app.web.dto.ApiUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Log4j2
@RequestMapping("/api/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserConverter converter;

    public UserControllerImpl(UserService userService, UserConverter converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody ApiUser apiUser) {
        UserProfile userToRegister = converter.toDomain(apiUser);
        UserProfile registeredUser = userService.register(userToRegister);
        return ResponseEntity
                .ok()
                .body(converter.toDTO(registeredUser));
    }
}
