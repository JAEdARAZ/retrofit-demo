package com.demodocker.controller;

import java.util.List;

import com.demodocker.model.Movie;

public interface IMoviesController {
    
    List<Movie> findMovies(String movieTitle);
    Movie getMovie(String movieId);
    
}
