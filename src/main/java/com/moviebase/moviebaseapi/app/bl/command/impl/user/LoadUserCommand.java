package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoadUserCommand extends Command {
    private final String username;
}
