package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandResult;
import com.moviebase.moviebaseapi.app.domain.User;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoadUserCommandResult extends CommandResult {
    private final User user;
}
