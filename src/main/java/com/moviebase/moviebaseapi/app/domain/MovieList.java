package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.SimpleGeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "movie_list_name_unique", columnNames = {"id", "user_profile_id", "name"}))
public class MovieList extends SimpleGeneralEntity {
    private String name;

    @ManyToMany
    @JoinTable(name = "user_movie_list",
                joinColumns = @JoinColumn(name = "list_id"),
                inverseJoinColumns = {@JoinColumn(name = "user_profile_id"), @JoinColumn(name = "movie_id")})
    private Set<UserMovie> userMovies;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile user;
}
