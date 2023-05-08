package com.driver;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")//1
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")//2
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")//3
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")//4
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie=movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")//5
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director=movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

   @GetMapping("/get-movies-by-director-name/{name}")//6
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
        List<String> list=movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
   }

   @GetMapping("/get-all-movies")//7
    public ResponseEntity<List<String>> findAllMovies(){
       List<String> list=movieService.findAllMovies();
       return new ResponseEntity<>(list, HttpStatus.OK);
   }

   @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(name+"deleted successfully",HttpStatus.OK);
   }

//   @DeleteMapping("/delete-all-directors")
//    public ResponseEntity<String> deleteAllDirectors(){
//        movieService.deleteAllDirectors();
//        return new ResponseEntity<>("Success",HttpStatus.OK);
//   }
}
