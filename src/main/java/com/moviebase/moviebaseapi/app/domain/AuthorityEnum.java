package com.moviebase.moviebaseapi.app.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AuthorityEnum {
    ADMIN("ADMIN"),
    USER("USER"),
    ;

    private String name;

}
