package com.demodocker.model;

import java.util.List;

import lombok.Data;

@Data
public class MoviesWrapper {
    private List<Movie> results;
}
