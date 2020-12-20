package com.moviebase.moviebaseapi.app.rest.controllers;

import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommand;
import com.moviebase.moviebaseapi.app.rest.model.ApiError;
import com.moviebase.moviebaseapi.app.rest.model.ApiUser;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "user")
public interface UserController {

    @ApiOperation(value = "Register new user", notes = "user", response = ApiUser.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<?> register(@ApiParam(value = "User data") RegisterUserCommand user);

}