package com.moviebase.moviebaseapi.app.rest.controllers;

import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.AddMovieCommand;
import com.moviebase.moviebaseapi.app.rest.model.ApiError;
import com.moviebase.moviebaseapi.app.rest.model.ApiList;
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
    ResponseEntity<?> create(@ApiParam(value = "List name") String listName);

    @ApiOperation(value = "Adds movie to list", notes = "new movie to list", response = ApiList.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<?> addMovie(@ApiParam(value = "Movie api key and list name") AddMovieCommand command);

    @ApiOperation(value = "Finds all lists for authorized user", notes = "finds all lists", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request", response = ApiError.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ApiError.class)
    })
    ResponseEntity<List<ApiList>> findAll();
}
