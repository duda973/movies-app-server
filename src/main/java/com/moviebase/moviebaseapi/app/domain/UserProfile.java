package com.moviebase.moviebaseapi.app.domain;

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
public class UserProfile extends GeneralEntity {
    private String firstName;
    private String lastName;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "user")
    private Set<UserMovie> movies = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<List> lists = new HashSet<>();
}
