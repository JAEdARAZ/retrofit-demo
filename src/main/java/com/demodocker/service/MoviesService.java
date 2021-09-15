package com.demodocker.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
    public List<Movie> findMovies(String movieTitle) {
        if (StringUtils.isNotBlank(movieTitle)) {
            return GenericCallRetrofit.request(moviesClient.findMovies(movieTitle, apiKey)).getResults();
        }
        return new ArrayList<Movie>();
    }

    @Override
    public Movie getMovie(@PathVariable String movieId) {
        return GenericCallRetrofit.request(moviesClient.getMovie(movieId, apiKey));
    }
}
