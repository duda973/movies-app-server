package com.moviebase.moviebaseapi.app.rest.converter;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.rest.model.ApiUser;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<ApiUser, UserProfile> {

    @Override
    public ApiUser toDTO(UserProfile domainObj) {
        PrerequisiteUtil.notNull(domainObj, "UserProfile you have passed is null");
        PrerequisiteUtil.notNull(domainObj, "UserProfile's User attribute you have passed is null");

        return ApiUser.builder()
                .firstName(domainObj.getFirstName())
                .lastName(domainObj.getLastName())
                .username(domainObj.getUsername())
                .password(null)
                .build();
    }
}
