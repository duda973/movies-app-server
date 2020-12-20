package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserRepository;
import com.moviebase.moviebaseapi.app.domain.User;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.exception.AppException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoadUserCommandExecutor implements CommandExecutor<LoadUserCommand, LoadUserCommandResult>, UserDetailsService {

    private final UserRepository userRepository;

    public LoadUserCommandExecutor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoadUserCommandResult execute(LoadUserCommand command) {
        User user = userRepository.findByUsername(command.getUsername());
        return new LoadUserCommandResult(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return execute(new LoadUserCommand(s)).getUser();
    }
}
