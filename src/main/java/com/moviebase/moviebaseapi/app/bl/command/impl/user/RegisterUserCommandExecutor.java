package com.moviebase.moviebaseapi.app.bl.command.impl.user;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserRepository;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.exception.AppException;
import org.springframework.core.env.PropertyResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserCommandExecutor extends CommandExecutor<RegisterUserCommand, RegisterUserCommandResult> {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public RegisterUserCommandExecutor(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        passwordEncoder = new BCryptPasswordEncoder(12);
    }

    @Override
    public void preSubmitHook(RegisterUserCommand command, PropertyResolver properties, UserProfile user) {
        if(userRepository.existsByUsername(command.getUsername()))
            throw new AppException("Username is taken by another user");
    }

    @Override
    public RegisterUserCommandResult doExecute(RegisterUserCommand command, PropertyResolver properties, UserProfile user) {

        UserProfile userProfile = convert(command);
        userProfile = userProfileRepository.save(userProfile);

        return new RegisterUserCommandResult(userProfile);
    }

    private UserProfile convert(RegisterUserCommand command) {
        UserProfile userProfile = new UserProfile();

        String encodedPassword = passwordEncoder.encode(command.getPassword());
        userProfile.setFirstName(command.getFirstName());
        userProfile.setLastName(command.getLastName());
        userProfile.setEmail(command.getEmail());
        userProfile.setUsername(command.getUsername());
        userProfile.setPassword(encodedPassword);
        userProfile.setAccountExpired(false);
        userProfile.setAccountLocked(false);
        userProfile.setEnabled(true);

        return userProfile;
    }
}
