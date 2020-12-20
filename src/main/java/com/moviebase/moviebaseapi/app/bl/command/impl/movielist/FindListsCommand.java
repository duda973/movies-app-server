package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindListsCommand extends Command {
    private final String username;
}
