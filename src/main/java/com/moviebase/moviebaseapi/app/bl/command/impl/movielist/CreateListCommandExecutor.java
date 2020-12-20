package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.command.base.CommandVoidResult;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.PropertyResolver;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CreateListCommandExecutor extends CommandExecutor<CreateListCommand, CommandVoidResult> {

    private final ListRepository listRepository;

    public CreateListCommandExecutor(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public CommandVoidResult doExecute(CreateListCommand command, PropertyResolver properties, UserProfile user) {
        MovieList entity = new MovieList(command.getName(), null, user);
        try {
            listRepository.save(entity);
        } catch (DataIntegrityViolationException e){
            log.info("User tried to create new list with name of existing list.");
            throw new IllegalArgumentException(String.format("List with name %s already exists in your lists, give unique name.", command.getName()));
        }
        return new CommandVoidResult();
    }
}
