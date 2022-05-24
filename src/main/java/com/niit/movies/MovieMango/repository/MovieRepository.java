package com.niit.movies.MovieMango.repository;
import com.niit.movies.MovieMango.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface MovieRepository extends MongoRepository<Movie,Integer>{
    @Query("{'actors.actorName' : {$in : [?0]}}")
    List<Movie> findAllMovieByActorName(String actorName);
}




