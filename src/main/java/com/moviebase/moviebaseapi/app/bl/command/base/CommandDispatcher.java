package com.moviebase.moviebaseapi.app.bl.command.base;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandDispatcher {
    protected Map<Class, CommandExecutor> preparedMap = new HashMap<>();

    public <C extends Command<R>, R extends CommandResult> R dispatch(C command){
        return (R) preparedMap.get(command.getClass()).execute(command);
    }
}
