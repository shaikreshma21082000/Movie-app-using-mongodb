package com.niit.movies.MovieMango.controller;

import com.niit.movies.MovieMango.domain.Movie;
import com.niit.movies.MovieMango.exception.MovieAlreadyExsistsException;
import com.niit.movies.MovieMango.exception.MovieNotFoundException;
import com.niit.movies.MovieMango.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/movie-service/")
public class MovieController {

    private ResponseEntity responseEntity;
    private MovieService movieService;


    @Autowired
    public MovieController( MovieService movieService) {
        this. movieService= movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExsistsException {
        try {
            movieService.saveMovieDetail(movie);
            responseEntity = new ResponseEntity(movie , HttpStatus.CREATED);
        } catch (MovieAlreadyExsistsException e) {
            throw new MovieAlreadyExsistsException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @DeleteMapping("movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") int movieId) throws MovieNotFoundException {

        try {
            movieService.deleteMovie(movieId);
            responseEntity = new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
        } catch (MovieNotFoundException e) {

            throw new MovieNotFoundException();

        }
        catch (Exception exception){
            String ex = exception.getMessage();
            System.out.println(exception.getMessage());
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies(){
        try{
            responseEntity = new ResponseEntity(movieService.getAllMovieDetail(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("movies/{actorName}")
    public ResponseEntity<?> getAllMoviesbasedOnActor(@PathVariable String actorName)throws MovieNotFoundException{
        try{
            responseEntity = new ResponseEntity(movieService.getAllMoviesByActors(actorName), HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            throw new MovieNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}