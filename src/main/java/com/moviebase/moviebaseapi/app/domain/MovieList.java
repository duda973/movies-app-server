package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.SimpleGeneralEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"userMovies", "user"}, callSuper = true)
@ToString(exclude = {"userMovies", "user"})
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "movie_list_name_unique", columnNames = {"user_profile_id", "name"}))
public class MovieList extends SimpleGeneralEntity {
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_movie_list",
                joinColumns = @JoinColumn(name = "list_id"),
                inverseJoinColumns = {@JoinColumn(name = "movie_id"), @JoinColumn(name = "user_profile_id")})
    private Set<UserMovie> userMovies;

    @ManyToOne
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile user;
}
