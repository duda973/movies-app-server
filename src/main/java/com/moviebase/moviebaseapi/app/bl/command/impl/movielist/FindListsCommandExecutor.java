package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.command.base.CommandVoidResult;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindListsCommandExecutor implements CommandExecutor<FindListsCommand, FindListsCommandResult> {

    private final UserProfileRepository userProfileRepository;
    private final ListRepository listRepository;

    public FindListsCommandExecutor(UserProfileRepository userProfileRepository, ListRepository listRepository) {
        this.userProfileRepository = userProfileRepository;
        this.listRepository = listRepository;
    }

    @Override
    public FindListsCommandResult execute(FindListsCommand command) {
        UserProfile user = userProfileRepository.findByUsername(command.getUsername());
        List<MovieList> result = listRepository.findAllByUser(user);
        return new FindListsCommandResult(result);
    }
}
