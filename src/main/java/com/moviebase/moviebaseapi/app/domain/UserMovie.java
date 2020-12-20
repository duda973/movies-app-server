package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.CompositeGeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = "lists", callSuper = true)
public class UserMovie extends CompositeGeneralEntity<UserMovieKey> {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "userMovies")
    private Set<MovieList> lists;

    public UserProfile getUserProfile(){
        if(id != null)
            return id.getUser();
        return null;
    }

    public void setUserProfile(UserProfile userProfile){
        if(id == null)
            id = new UserMovieKey();
        id.setUser(userProfile);
    }

    public Movie getMovie(){
        if(id != null)
            return id.getMovie();
        return null;
    }

    public void setMovie(Movie movie){
        if(id == null)
            id = new UserMovieKey();
        id.setMovie(movie);
    }
}
