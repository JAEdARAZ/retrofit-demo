package com.demodocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demodocker.model.Movie;
import com.demodocker.retrofit.GenericCallRetrofit;
import com.demodocker.retrofit.client.MoviesClient;

@Service
public class MoviesService implements IMoviesService {

    @Value("${tmdb.api.key}")
    private String apiKey;
    
    @Autowired
    MoviesClient moviesClient;

    @Override
    public Movie getMovie(@PathVariable String movieId) {
        return GenericCallRetrofit.request(moviesClient.getMovie(movieId, apiKey));
    }
}
