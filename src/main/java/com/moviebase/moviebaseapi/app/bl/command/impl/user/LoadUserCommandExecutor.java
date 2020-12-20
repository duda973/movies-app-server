package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.domain.User;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.core.env.PropertyResolver;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoadUserCommandExecutor extends CommandExecutor<LoadUserCommand, LoadUserCommandResult> implements UserDetailsService {

    private final UserProfileRepository userProfileRepository;

    public LoadUserCommandExecutor(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public LoadUserCommandResult doExecute(LoadUserCommand command, PropertyResolver properties, UserProfile user) {
        UserProfile result = userProfileRepository.findByUsername(command.getUsername());
        return new LoadUserCommandResult(result);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return execute(new LoadUserCommand(s), null, null).getUser();
    }
}
