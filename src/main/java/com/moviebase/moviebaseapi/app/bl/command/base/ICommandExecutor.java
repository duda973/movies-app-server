package com.moviebase.moviebaseapi.app.bl.command.base;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.core.env.PropertyResolver;

public interface ICommandExecutor<C extends Command, R extends CommandResult> {
    void preSubmitHook(C command, PropertyResolver properties, UserProfile user);
    R doExecute(C command, PropertyResolver properties, UserProfile user);
    void postSubmitHook(C command, PropertyResolver properties, UserProfile user);
    R execute(C command, PropertyResolver properties, UserProfile user);
}
