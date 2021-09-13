package com.demodocker.retrofit.client;

import com.demodocker.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesClient {

    @GET("/3/movie/{movieId}")
    public Call<Movie> getMovie(@Path("movieId") String movieId, @Query("api_key") String apiKey);

}
