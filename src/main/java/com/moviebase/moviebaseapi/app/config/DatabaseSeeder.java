package com.moviebase.moviebaseapi.app.config;

import com.moviebase.moviebaseapi.app.bl.repository.UserRepository;
import com.moviebase.moviebaseapi.app.domain.Authority;
import com.moviebase.moviebaseapi.app.domain.AuthorityEnum;
import com.moviebase.moviebaseapi.app.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    public DatabaseSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User userAdmin = new User(
                "$2a$12$7V.9/X/IiweR1AMxdcG9SufZ.QDM6pLHBrw3rI6TRNafiGFCBfE/e",
                "admin",
                Collections.singletonList(new Authority(AuthorityEnum.ADMIN)),
                false,
                false,
                false,
                true,
                null
        );
        userRepository.save(userAdmin);

        User basicUser = new User(
                "$2a$12$7V.9/X/IiweR1AMxdcG9SufZ.QDM6pLHBrw3rI6TRNafiGFCBfE/e",
                "user",
                Collections.singletonList(new Authority(AuthorityEnum.USER)),
                false,
                false,
                false,
                true,
                null
        );
        userRepository.save(basicUser);
    }
}
