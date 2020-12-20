package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.Command;
import com.moviebase.moviebaseapi.app.bl.command.base.CommandVoidResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateListCommand extends Command<CommandVoidResult> {
    private final String name;
    private final String username;
}
