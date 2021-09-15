package com.demodocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demodocker.model.Movie;
import com.demodocker.service.IMoviesService;

@RestController
public class MoviesController implements IMoviesController{

    @Autowired
    IMoviesService moviesService;
    
    @Override
    @GetMapping("/movies")
    public List<Movie> findMovies(@RequestParam String movieTitle) {
        return moviesService.findMovies(movieTitle);
    }
    
    @Override
    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable String movieId) {
        return moviesService.getMovie(movieId);
    }

}
