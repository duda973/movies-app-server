package com.moviebase.moviebaseapi.command;

import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.CreateListCommand;
import com.moviebase.moviebaseapi.app.bl.command.impl.movielist.CreateListCommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class CreateListCommandTest extends AbstractCommandTest {

	@Autowired
	private CreateListCommandExecutor commandExecutor;
	@Autowired
	private ListRepository listRepository;

	@Test
	public void test(){
		CreateListCommand command = new CreateListCommand("Nova lista");

		commandExecutor.doExecute(command, null, userProfile);

		List<MovieList> lists = listRepository.findAllByUser(userProfile);

		assertNotNull(lists);
		assertEquals(1, lists.size());
		assertEquals(command.getName(), lists.get(0).getName());
		assertNotNull(lists.get(0).getUser());
		assertEquals(userProfile.getId(), lists.get(0).getUser().getId());
	}
}
