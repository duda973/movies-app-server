package com.moviebase.moviebaseapi.app.bl.command.base;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.core.env.PropertyResolver;

public abstract class CommandExecutor<C extends Command, R extends CommandResult> implements ICommandExecutor<C, R> {

    // Template method
    @Override
    public void preSubmitHook(C command, PropertyResolver properties, UserProfile user) {
    }

    @Override
    public abstract R doExecute(C command, PropertyResolver properties, UserProfile user);

    // Template method
    @Override
    public void postSubmitHook(C command, PropertyResolver properties, UserProfile user) {
    }

    public R execute(C command, PropertyResolver properties, UserProfile user){
        preSubmitHook(command, properties, user);
        R result = doExecute(command, properties, user);
        postSubmitHook(command, properties, user);
        return result;
    }
}
