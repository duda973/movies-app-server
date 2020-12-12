package com.moviebase.moviebaseapi.app.util;

import com.moviebase.moviebaseapi.app.util.exception.AppException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PrerequisiteUtil {

    public void notNull(Object obj, String msg) throws AppException {
        if(obj == null)
            throw new AppException(msg);
    }
}
