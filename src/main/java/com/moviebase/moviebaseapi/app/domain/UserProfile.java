package com.moviebase.moviebaseapi.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserProfile extends User {
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<UserMovie> movies = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<MovieList> movieLists = new HashSet<>();

    public UserProfile(User user) {
        this.id = user.getId();
        this.createdAt = user.getCreatedAt();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.enabled;
        this.accountExpired = user.accountExpired;
        this.accountLocked = user.accountLocked;
        this.credentialsExpired = user.credentialsExpired;
        this.authorities = (java.util.List<Authority>) user.getAuthorities();
    }
}
