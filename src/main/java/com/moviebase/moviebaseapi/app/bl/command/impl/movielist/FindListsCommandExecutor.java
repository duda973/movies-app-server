package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindListsCommandExecutor extends CommandExecutor<FindListsCommand, FindListsCommandResult> {

    private final ListRepository listRepository;

    public FindListsCommandExecutor(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public FindListsCommandResult doExecute(FindListsCommand command, PropertyResolver properties, UserProfile user) {
        List<MovieList> result = listRepository.findAllByUser(command.getUser());
        return new FindListsCommandResult(result);
    }
}
