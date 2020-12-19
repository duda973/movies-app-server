package com.moviebase.moviebaseapi.app.web.converter;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.PrerequisiteUtil;
import com.moviebase.moviebaseapi.app.web.dto.ApiUser;
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

    @Override
    public UserProfile toDomain(ApiUser dtoObj) {
        PrerequisiteUtil.notNull(dtoObj, "User you have passed is null");

        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(dtoObj.getFirstName());
        userProfile.setLastName(dtoObj.getLastName());
        userProfile.setUsername(dtoObj.getUsername());
        userProfile.setPassword(dtoObj.getPassword());
        userProfile.setEmail(dtoObj.getEmail());

        return userProfile;
    }
}
