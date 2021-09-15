package com.demodocker.service;

import java.util.List;

import com.demodocker.model.Movie;

public interface IMoviesService {

    Movie getMovie(String movieId);
    List<Movie> findMovies(String movieTitle);

}
