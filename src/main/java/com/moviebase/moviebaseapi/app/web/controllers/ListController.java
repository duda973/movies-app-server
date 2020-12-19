package com.moviebase.moviebaseapi.app.web.controllers;

import com.moviebase.moviebaseapi.app.web.dto.ApiError;
import com.moviebase.moviebaseapi.app.web.dto.ApiList;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "list")
public interface ListController {

    @ApiOperation(value = "Creates new list", notes = "list", response = ApiList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<?> create(@ApiParam(value = "List object") ApiList list);

    @ApiOperation(value = "Finds all lists for authorized user", notes = "finds all lists", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<java.util.List<ApiList>> findAll();
}
