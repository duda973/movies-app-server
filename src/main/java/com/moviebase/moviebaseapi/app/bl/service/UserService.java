package com.moviebase.moviebaseapi.app.bl.service;

import com.moviebase.moviebaseapi.app.domain.UserProfile;
import com.moviebase.moviebaseapi.app.util.exception.AppException;

public interface UserService {

    UserProfile register(UserProfile user) throws AppException;
}
