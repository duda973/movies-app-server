package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandResult;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindListsCommandResult extends CommandResult {
    private final List<MovieList> lists;
}
