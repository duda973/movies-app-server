package com.moviebase.moviebaseapi.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class List extends GeneralEntity {
    private String name;

    @ManyToMany
    @JoinTable(name = "user_movie_list",
                joinColumns = @JoinColumn(name = "list_id"),
                inverseJoinColumns = {@JoinColumn(name = "user_profile_id"), @JoinColumn(name = "movie_id")})
    private Set<UserMovie> userMovies;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile user;
}
