package com.moviebase.moviebaseapi.app.bl.movieapi;

import com.moviebase.moviebaseapi.app.bl.movieapi.model.ImdbMovie;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class MovieApiServiceImpl implements MovieApiService {
    private final Environment environment;
    private final RestTemplate restTemplate;

    public MovieApiServiceImpl(Environment environment, RestTemplate restTemplate) {
        this.environment = environment;
        this.restTemplate = restTemplate;
    }

    @Override
    public ImdbMovie getByApiKey(String movieApiKey) {
        String url = environment.getProperty("imdb.api.base.url") + "/movie/" + movieApiKey + "?api_key=" + environment.getProperty("imdb.api.key");
        return restTemplate.getForObject(url, ImdbMovie.class);
    }
}
