package com.moviebase.moviebaseapi.app.web.controllers;

import com.moviebase.moviebaseapi.app.web.dto.ApiError;
import com.moviebase.moviebaseapi.app.web.dto.ApiUser;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

@Api(tags = "user")
public interface UserController {

    @ApiOperation(value = "Register new user", notes = "user", response = ApiUser.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<?> register(@ApiParam(value = "User object") ApiUser user);

}
