package com.moviebase.moviebaseapi.app.bl.command.impl.movielist;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.repository.ListRepository;
import com.moviebase.moviebaseapi.app.bl.repository.MovieRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserMovieRepository;
import com.moviebase.moviebaseapi.app.bl.repository.UserProfileRepository;
import com.moviebase.moviebaseapi.app.domain.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class AddMovieCommandExecutor implements CommandExecutor<AddMovieCommand, AddMovieCommandResult> {

    private final UserProfileRepository userProfileRepository;
    private final MovieRepository movieRepository;
    private final UserMovieRepository userMovieRepository;
    private final ListRepository listRepository;

    public AddMovieCommandExecutor(UserProfileRepository userProfileRepository, MovieRepository movieRepository, UserMovieRepository userMovieRepository, ListRepository listRepository) {
        this.userProfileRepository = userProfileRepository;
        this.movieRepository = movieRepository;
        this.userMovieRepository = userMovieRepository;
        this.listRepository = listRepository;
    }

    @Override
    public AddMovieCommandResult execute(AddMovieCommand command) {
        UserProfile user = userProfileRepository.findByUsername(command.getUsername());

        if(!listRepository.existsByNameAndUser(command.getListName(), user))
            throw new IllegalArgumentException("List does not exists");

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

        // TODO fetch movie from api instead mocking
        Movie movie = new Movie(movieApiKey, "New Movie", "New Movie Description", null);
        return movieRepository.save(movie);
    }
}
