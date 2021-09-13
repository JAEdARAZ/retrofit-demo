package com.demodocker.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.demodocker.model.Movie;
import com.demodocker.retrofit.client.MoviesClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class MoviesService implements IMoviesService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.baseurl}")
    private String tmdbBaseUrl;

    @Override
    public Movie getMovie(@PathVariable String movieId) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(tmdbBaseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();

        MoviesClient service = retrofit.create(MoviesClient.class);
        Call<Movie> callSync = service.getMovie(movieId, apiKey);

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
