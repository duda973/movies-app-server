package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.movieapi.model.ImdbMovie;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.MovieRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserMovieRepository;
import com.moviebase.moviebaseapi.app.bl.movieapi.MovieApiService;
import com.moviebase.moviebaseapi.app.domain.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.PropertyResolver;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AddMovieCommandExecutor extends CommandExecutor<AddMovieCommand, AddMovieCommandResult> {

    private final MovieApiService movieApiService;
    private final MovieRepository movieRepository;
    private final UserMovieRepository userMovieRepository;
    private final ListRepository listRepository;

    public AddMovieCommandExecutor(MovieApiService movieApiService,
                                   MovieRepository movieRepository,
                                   UserMovieRepository userMovieRepository,
                                   ListRepository listRepository) {
        this.movieApiService = movieApiService;
        this.movieRepository = movieRepository;
        this.userMovieRepository = userMovieRepository;
        this.listRepository = listRepository;
    }

    @Override
    public void preSubmitHook(AddMovieCommand command, PropertyResolver properties, UserProfile user) {
        if(!listRepository.existsByNameAndUser(command.getListName(), user))
            throw new IllegalArgumentException("List does not exists");
    }

    @Override
    public AddMovieCommandResult doExecute(AddMovieCommand command, PropertyResolver properties, UserProfile user) {
        preSubmitHook(command, properties, user);

        MovieList list = listRepository.findByNameAndUser(command.getListName(), user);

        Movie movie = getOrCreate(command.getMovieApiKey());
        UserMovie userMovie = getOrCreate(user, movie);

        if(!list.getUserMovies().add(userMovie))
            throw new IllegalArgumentException("Movie is already added to this list.");

        list = listRepository.save(list);
        return new AddMovieCommandResult(list);
    }

    private UserMovie getOrCreate(UserProfile user, Movie movie) {
        if(userMovieRepository.existsById(new UserMovieKey(user, movie)))
            return userMovieRepository.findById(new UserMovieKey(user, movie)).get();
        else {
            UserMovie userMovie = new UserMovie();
            userMovie.setUserProfile(user);
            userMovie.setMovie(movie);
            userMovie = userMovieRepository.save(userMovie);
            return userMovie;
        }
    }

    private Movie getOrCreate(String movieApiKey) {
        if(movieRepository.existsByApiId(movieApiKey))
            return movieRepository.findByApiId(movieApiKey);

        ImdbMovie imdbMovie = movieApiService.getByApiKey(movieApiKey);
        Movie movie = convert(imdbMovie);
        return movieRepository.save(movie);
    }

    private Movie convert(ImdbMovie imdbMovie) {
        Movie movie = new Movie();
        movie.setApiId(imdbMovie.getId());
        movie.setImdbId(imdbMovie.getImdbId());
        movie.setTitle(imdbMovie.getTitle());
        movie.setOverview(imdbMovie.getOverview());
        return movie;
    }
}
