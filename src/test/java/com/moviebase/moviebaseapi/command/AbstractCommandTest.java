package com.moviebase.moviebaseapi.command;

import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommand;
import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommandExecutor;
import com.moviebase.moviebaseapi.app.bl.command.impl.user.RegisterUserCommandResult;
import com.moviebase.moviebaseapi.app.domain.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public abstract class AbstractCommandTest {

	protected UserProfile userProfile;
	@Autowired
	private RegisterUserCommandExecutor executor;

	@BeforeEach
	public void initUser(){
		RegisterUserCommand command = new RegisterUserCommand("test", "user", "test-user", "test-user-pwd", "test@user.com");
		RegisterUserCommandResult result = executor.execute(command);
		userProfile = result.getUser();
	}

}
