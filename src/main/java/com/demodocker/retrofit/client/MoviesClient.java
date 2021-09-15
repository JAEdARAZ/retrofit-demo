package com.demodocker.retrofit.client;

import com.demodocker.model.Movie;
import com.demodocker.model.MoviesWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesClient {

    @GET("/3/search/movie")
    public Call<MoviesWrapper> findMovies(@Query("query") String movieTitle, @Query("api_key") String apiKey);
    
    @GET("/3/movie/{movieId}")
    public Call<Movie> getMovie(@Path("movieId") String movieId, @Query("api_key") String apiKey);

}
