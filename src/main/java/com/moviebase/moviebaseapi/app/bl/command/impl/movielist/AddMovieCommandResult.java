package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandResult;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddMovieCommandResult extends CommandResult {
    private final MovieList list;
}
