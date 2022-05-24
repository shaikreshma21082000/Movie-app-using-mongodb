package com.niit.movies.MovieMango.service;

import com.niit.movies.MovieMango.domain.Movie;
import com.niit.movies.MovieMango.exception.MovieAlreadyExsistsException;
import com.niit.movies.MovieMango.exception.MovieNotFoundException;
import com.niit.movies.MovieMango.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieServiceImpl() {
        super();
    }

    @Override
    public Movie saveMovieDetail(Movie movie) throws MovieAlreadyExsistsException {
        if (movieRepository.findById(movie.getMovieId()).isPresent())
            throw new MovieAlreadyExsistsException();
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovie(int id) throws MovieNotFoundException {
        boolean flag = false;
        if (movieRepository.findById(id).isEmpty())
            throw new MovieNotFoundException();
        else {
            movieRepository.deleteById(id);
            flag=true;
        }
        return flag;
    }

    @Override
    public List<Movie> getAllMovieDetail() throws Exception {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getAllMoviesByActors(String actorName) throws MovieNotFoundException {
        if (movieRepository.findAllMovieByActorName(actorName).isEmpty()) {
            throw new MovieNotFoundException();
        }
        return movieRepository.findAllMovieByActorName(actorName);

    }
}