package com.moviebase.moviebaseapi.app.bl.command.base;

public interface CommandExecutor<C extends Command<R>, R extends CommandResult> {
    R execute(C command);
}
