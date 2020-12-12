package com.moviebase.moviebaseapi.app.domain;

import com.moviebase.moviebaseapi.app.domain.abstraction.BasicGeneralEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends BasicGeneralEntity {
    private String apiId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "movie")
    private Set<UserMovie> users = new HashSet<>();
}
