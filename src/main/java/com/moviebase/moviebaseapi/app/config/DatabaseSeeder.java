package com.moviebase.moviebaseapi.app.config;

import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserRepository;
import com.moviebase.moviebaseapi.app.domain.Authority;
import com.moviebase.moviebaseapi.app.domain.AuthorityEnum;
import com.moviebase.moviebaseapi.app.domain.User;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserProfileRepository userProfileRepository;

    public DatabaseSeeder(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(
                "$2a$12$7V.9/X/IiweR1AMxdcG9SufZ.QDM6pLHBrw3rI6TRNafiGFCBfE/e",
                "user1",
                Collections.singletonList(new Authority(AuthorityEnum.USER)),
                false,
                false,
                false,
                true
        );

        UserProfile userProfile1 = new UserProfile(user1);
        userProfile1.setFirstName("User1");
        userProfile1.setLastName("User1");
        userProfile1.setEmail("user1@test.com");
        userProfileRepository.save(userProfile1);

        User user2 = new User(
                "$2a$12$7V.9/X/IiweR1AMxdcG9SufZ.QDM6pLHBrw3rI6TRNafiGFCBfE/e",
                "user2",
                Collections.singletonList(new Authority(AuthorityEnum.USER)),
                false,
                false,
                false,
                true
        );

        UserProfile userProfile2 = new UserProfile(user2);
        userProfile2.setFirstName("User2");
        userProfile2.setLastName("User2");
        userProfile2.setEmail("user2@test.com");
        userProfileRepository.save(userProfile2);
    }
}
