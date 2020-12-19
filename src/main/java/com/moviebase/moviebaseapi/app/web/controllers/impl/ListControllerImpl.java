package com.moviebase.moviebaseapi.app.web.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.service.ListService;
import com.moviebase.moviebaseapi.app.domain.List;
import com.moviebase.moviebaseapi.app.web.controllers.AbstractController;
import com.moviebase.moviebaseapi.app.web.controllers.ListController;
import com.moviebase.moviebaseapi.app.web.converter.ListConverter;
import com.moviebase.moviebaseapi.app.web.dto.ApiList;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Log4j2
@RequestMapping("/api/list")
public class ListControllerImpl extends AbstractController implements ListController {

    private final ListService listService;
    private final ListConverter converter;

    public ListControllerImpl(ListService listService, ListConverter converter) {
        this.listService = listService;
        this.converter = converter;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ApiList apiList) {
        List listToCreate = converter.toDomain(apiList);
        List createdList = listService.create(listToCreate, getPrincipal().getUsername());

        return ResponseEntity
                .ok()
                .body(converter.toDTO(createdList));
    }
}
