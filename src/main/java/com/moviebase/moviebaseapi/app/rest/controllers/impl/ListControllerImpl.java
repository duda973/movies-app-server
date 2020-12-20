package com.moviebase.moviebaseapi.app.rest.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.*;
import com.moviebase.moviebaseapi.app.rest.controllers.AbstractController;
import com.moviebase.moviebaseapi.app.rest.controllers.ListController;
import com.moviebase.moviebaseapi.app.rest.converter.ListConverter;
import com.moviebase.moviebaseapi.app.rest.model.ApiList;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody String listName) {
        commandDispatcher.dispatch(new CreateListCommand(listName, getPrincipal().getUsername()));
        return ResponseEntity
                .ok()
                .build();
    }

    @Override
    @PostMapping("/add-movie")
    public ResponseEntity<?> addMovie(@Valid @RequestBody AddMovieCommand command) {
        command.setUsername(getPrincipal().getUsername());
        AddMovieCommandResult result = commandDispatcher.dispatch(command);
        return ResponseEntity
                .ok()
                .body(converter.toDTO(result.getList()));
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ApiList>> findAll() {
        FindListsCommandResult result = commandDispatcher.dispatch(new FindListsCommand(getPrincipal().getUsername()));

        return ResponseEntity
                .ok()
                .body(converter.toDTO(result.getLists()));
    }
}
