package com.moviebase.moviebaseapi.app.rest.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.*;
import com.moviebase.moviebaseapi.app.rest.controllers.AbstractController;
import com.moviebase.moviebaseapi.app.rest.controllers.ListController;
import com.moviebase.moviebaseapi.app.rest.converter.ListConverter;
import com.moviebase.moviebaseapi.app.rest.model.ApiList;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Log4j2
@RequestMapping("/api/list")
public class ListControllerImpl extends AbstractController implements ListController {

    private final ListConverter converter;

    public ListControllerImpl(ListConverter converter) {
        this.converter = converter;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody String listName) {
        commandDispatcher.dispatch(new CreateListCommand(listName), null, getUserProfile());
        return ResponseEntity
                .ok()
                .build();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add-movie")
    public ResponseEntity<?> addMovie(@Valid @RequestBody AddMovieCommand command) {
        AddMovieCommandResult result = commandDispatcher.dispatch(command, null, getUserProfile());
        return ResponseEntity
                .ok()
                .body(converter.toDTO(result.getList()));
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/all")
    public ResponseEntity<List<ApiList>> findAll() {
        FindListsCommandResult result = commandDispatcher.dispatch(new FindListsCommand(getUserProfile()), null, getUserProfile());

        return ResponseEntity
                .ok()
                .body(converter.toDTO(result.getLists()));
    }
}
