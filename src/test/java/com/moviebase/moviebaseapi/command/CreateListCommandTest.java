package com.moviebase.moviebaseapi.command;

import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.*;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class CreateListCommandTest extends AbstractCommandTest {

	@Autowired
	private CreateListCommandExecutor commandExecutor;
	@Autowired
	private ListRepository listRepository;

	@Test
	public void test(){
		CreateListCommand command = new CreateListCommand("Nova lista", userProfile.getUsername());

		commandExecutor.execute(command);

		List<MovieList> lists = listRepository.findAllByUser(userProfile);

		Assert.assertNotNull(lists);
		Assert.assertEquals(1, lists.size());
		Assert.assertEquals(command.getName(), lists.get(0).getName());
		Assert.assertNotNull(lists.get(0).getUser());
		Assert.assertEquals(userProfile.getId(), lists.get(0).getUser().getId());
	}
}
