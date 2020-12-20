package com.moviebase.moviebaseapi.app.bl.movieapi;

import com.moviebase.moviebaseapi.app.bl.movieapi.model.ImdbMovie;

public interface MovieApiService {

    ImdbMovie getByApiKey(String movieApiKey);
}
