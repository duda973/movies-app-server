package com.moviebase.moviebaseapi.service;

import com.moviebase.moviebaseapi.app.bl.service.ListService;
import com.moviebase.moviebaseapi.app.domain.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ListServiceTest extends AbstractServiceTest {

	@Autowired
	private ListService listService;

	@Test
	public void create() {
		List list = new List();
		list.setName("List");

		List createdList = listService.create(list, userProfile.getUsername());

		createdList = listService.get(createdList.getId());

		Assert.assertNotNull(createdList);
		Assert.assertEquals(list.getName(), createdList.getName());
		Assert.assertNotNull(createdList.getUser());
		Assert.assertEquals(userProfile.getId(), createdList.getUser().getId());
	}
}
