package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.SimpleGeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends SimpleGeneralEntity {
    private Long apiId;
    private String imdbId;
    private String title;
    @Lob
    private String overview;

    @OneToMany(mappedBy = "id.movie")
    private Set<UserMovie> users = new HashSet<>();
}
