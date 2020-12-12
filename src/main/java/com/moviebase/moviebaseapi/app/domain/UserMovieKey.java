package com.moviebase.moviebaseapi.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserMovieKey implements Serializable {
    @Column(name = "user_profile_id")
    private Integer userId;

    @Column(name = "movie_id")
    private Integer movieId;
}
