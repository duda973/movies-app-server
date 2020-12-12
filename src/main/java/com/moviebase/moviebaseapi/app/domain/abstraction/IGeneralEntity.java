package com.moviebase.moviebaseapi.app.domain.abstraction;

import java.io.Serializable;
import java.time.Instant;

public interface IGeneralEntity<T extends Serializable> {
    T getId();
    Instant getCreatedAt();
    Instant getModifiedAt();
    int getVersion();
}
