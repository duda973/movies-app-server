package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.command.base.CommandVoidResult;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CreateListCommandExecutor implements CommandExecutor<CreateListCommand, CommandVoidResult> {

    private final UserProfileRepository userProfileRepository;
    private final ListRepository listRepository;

    public CreateListCommandExecutor(UserProfileRepository userProfileRepository, ListRepository listRepository) {
        this.userProfileRepository = userProfileRepository;
        this.listRepository = listRepository;
    }

    @Override
    public CommandVoidResult execute(CreateListCommand command) {
        MovieList entity = convert(command);
        try {
            listRepository.save(entity);
        } catch (DataIntegrityViolationException e){
            log.info("User tried to create new list with name of existing list.");
            throw new IllegalArgumentException(String.format("List with name %s already exists in your lists, give unique name.", command.getName()));
        }
        return new CommandVoidResult();
    }

    private MovieList convert(CreateListCommand command) {
        UserProfile user = userProfileRepository.findByUsername(command.getUsername());
        return new MovieList(command.getName(), null, user);
    }
}
