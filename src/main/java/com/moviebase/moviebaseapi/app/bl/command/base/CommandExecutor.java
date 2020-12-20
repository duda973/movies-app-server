package com.moviebase.moviebaseapi.app.bl.command.base;

public interface CommandExecutor<C extends Command, R extends CommandResult> {
    R execute(C command);
}
