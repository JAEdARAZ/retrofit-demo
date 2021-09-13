package com.demodocker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demodocker.model.Movie;
import com.demodocker.retrofit.client.MoviesClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
public class MainController {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @GetMapping("/main")
    public String getHelloWorld() {
        return "hey boy how is it going";
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable String movieId) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
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

        return null;
    }

}
