package com.moviebase.moviebaseapi.app.rest.controllers.impl;

import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommand;
import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommandResult;
import com.moviebase.moviebaseapi.app.rest.controllers.AbstractController;
import com.moviebase.moviebaseapi.app.rest.controllers.UserController;
import com.moviebase.moviebaseapi.app.rest.converter.UserConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Log4j2
@RequestMapping("/api/user")
public class UserControllerImpl extends AbstractController implements UserController {

    private final UserConverter converter;

    public UserControllerImpl(UserConverter converter) {
        this.converter = converter;
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterUserCommand command) {
        RegisterUserCommandResult result = commandDispatcher.dispatch(command, null, null);

        return ResponseEntity
                .ok()
                .body(converter.toDTO(result.getUser()));
    }
}
