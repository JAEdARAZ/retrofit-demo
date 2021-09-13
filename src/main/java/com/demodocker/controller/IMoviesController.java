package com.demodocker.controller;

import com.demodocker.model.Movie;

public interface IMoviesController {
    
    Movie getMovie(String movieId);
    
}
