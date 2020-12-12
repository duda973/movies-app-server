package com.moviebase.moviebaseapi.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserMovie {
    @EmbeddedId
    private UserMovieKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_profile_id")
    private UserProfile user;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime registrationTime;

    @ManyToMany(mappedBy = "userMovies")
    private Set<List> lists;
}