package com.moviebase.moviebaseapi.service;

import com.moviebase.moviebaseapi.app.bl.service.ListService;
import com.moviebase.moviebaseapi.app.domain.MovieList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class MovieListServiceTest extends AbstractServiceTest {

	@Autowired
	private ListService listService;

	@Test
	public void create() {
		MovieList movieList = new MovieList();
		movieList.setName("List");

		MovieList createdMovieList = listService.create(movieList, userProfile.getUsername());

		createdMovieList = listService.get(createdMovieList.getId());

		Assert.assertNotNull(createdMovieList);
		Assert.assertEquals(movieList.getName(), createdMovieList.getName());
		Assert.assertNotNull(createdMovieList.getUser());
		Assert.assertEquals(userProfile.getId(), createdMovieList.getUser().getId());
	}

	@Test
	public void findAll() {
		MovieList movieList = new MovieList();
		movieList.setName("List");

		MovieList createdMovieList = listService.create(movieList, userProfile.getUsername());

		List<MovieList> list = listService.findAll(userProfile.getUsername());

		Assert.assertNotNull(list);
		Assert.assertEquals(1, list.size());
		Assert.assertEquals(createdMovieList.getName(), list.get(0).getName());
		Assert.assertEquals(createdMovieList.getUser().getUsername(), list.get(0).getUser().getUsername());
	}
}
