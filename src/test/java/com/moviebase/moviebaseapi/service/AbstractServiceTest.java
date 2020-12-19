package com.moviebase.moviebaseapi.service;

import com.moviebase.moviebaseapi.app.bl.service.UserService;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public abstract class AbstractServiceTest {

	protected UserProfile userProfile;

	@Autowired
	private UserService userService;

	@BeforeEach
	public void initUser(){
		userProfile = new UserProfile();
		userProfile.setFirstName("Test");
		userProfile.setLastName("User");
		userProfile.setUsername("test-user");
		userProfile.setPassword("test-user-password");
		userProfile.setEmail("test@user.com");
		userProfile = userService.register(userProfile);
	}

}
