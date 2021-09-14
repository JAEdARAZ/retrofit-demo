package com.demodocker.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demodocker.model.Movie;
import com.demodocker.retrofit.RetrofitClientGenerator;
import com.demodocker.retrofit.client.MoviesClient;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class MoviesService implements IMoviesService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.baseurl}")
    private String tmdbBaseUrl;

    @Override
    public Movie getMovie(@PathVariable String movieId) {
        MoviesClient moviesClient = RetrofitClientGenerator.createService(MoviesClient.class);
        Call<Movie> callSync = moviesClient.getMovie(movieId, apiKey);

        try {
            Response<Movie> response;
            response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Movie();
    }

}