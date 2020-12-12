package com.moviebase.moviebaseapi.app.web.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.service.UserService;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.exception.AppException;
import com.moviebase.moviebaseapi.app.web.controllers.UserController;
import com.moviebase.moviebaseapi.app.web.converter.UserConverter;
import com.moviebase.moviebaseapi.app.web.dto.ApiError;
import com.moviebase.moviebaseapi.app.web.dto.ApiUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
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
        UserProfile userToRegister;
        UserProfile registeredUser;
        try {
            userToRegister = converter.toDomain(apiUser);
        } catch (AppException e) {
            log.error("Failed to register user, ex: ", e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiError(HttpStatus.BAD_REQUEST, e));
        }

        try {
            registeredUser = userService.register(userToRegister);
        } catch (AppException e) {
            log.error("Failed to register user, ex: ", e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiError(HttpStatus.BAD_REQUEST, e));
        }

        try {
            return ResponseEntity
                    .ok()
                    .body(converter.toDTO(registeredUser));
        } catch (AppException e) {
            log.error("Failed to register user, ex: ", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e));
        }
    }
}
