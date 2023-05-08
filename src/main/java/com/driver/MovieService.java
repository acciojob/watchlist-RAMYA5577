package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director){
        return movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String name){
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return movieRepository.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        List<String> list=movieRepository.findAllMovies();
        return list;
    }

    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }

//    public void deleteAllDirectors(){
//        movieRepository.deleteAllDirectors();
//    }
}
