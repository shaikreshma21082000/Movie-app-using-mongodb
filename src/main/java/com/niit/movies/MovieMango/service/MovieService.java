package com.niit.movies.MovieMango.service;
import com.niit.movies.MovieMango.domain.Movie;
import com.niit.movies.MovieMango.exception.MovieAlreadyExsistsException;
import com.niit.movies.MovieMango.exception.MovieNotFoundException;

import java.util.List;
public interface MovieService {
    Movie saveMovieDetail(Movie movie) throws MovieAlreadyExsistsException;
    boolean deleteMovie(int id) throws MovieNotFoundException;
    List<Movie> getAllMovieDetail() throws Exception;
    List<Movie> getAllMoviesByActors(String actorName) throws MovieNotFoundException;

}

