package com.moviebase.moviebaseapi.app.bl.command.base;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.core.env.PropertyResolver;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandDispatcher {
    protected Map<Class, ICommandExecutor> preparedMap = new HashMap<>();

    public <C extends Command, R extends CommandResult> R dispatch(C command, PropertyResolver properties, UserProfile user){
        return (R) preparedMap.get(command.getClass()).execute(command, properties, user);
    }
}
