package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterUserCommand extends Command<RegisterUserCommandResult> {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;
}
