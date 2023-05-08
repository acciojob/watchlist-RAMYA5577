package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

   private Map<String,Movie> movieMap;
   private Map<String,Director> directorMap;
   private Map<String, List<String>> movieDirectorMap;


    public MovieRepository(){
        this.movieMap=new HashMap<String,Movie>();
        this.directorMap=new HashMap<String,Director>();
        this.movieDirectorMap=new HashMap<String,List<String>>();
    }
    public String addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
        return "";
    }

    public String addDirector(Director director){
        directorMap.put(director.getName(),director);
        return "";
    }

    public Director addMovieDirectorPair(String movie, String director){
       if(movieMap.containsKey(movie) && directorMap.containsKey(director)) {
           List<String> list = new ArrayList<>();
           if (movieDirectorMap.containsKey(director))
               list = movieDirectorMap.get(director);

           list.add(movie);
           movieDirectorMap.put(director, list);
       }
       return directorMap.get(director);
       }

        public Movie getMovieByName(String movie){
            return movieMap.get(movie);
        }

       public Director getDirectorByName(String director){
           return directorMap.get(director);
        }

    public List<String> getMoviesByDirectorName(String name) {
       return movieDirectorMap.get(name);
    }

    public List<String> findAllMovies(){
       return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorByName(String name) {
       List<String> movies=new ArrayList<>();
       //1.find the movie name by director from the pair

       if(movieDirectorMap.containsKey(name)){
           movies=movieDirectorMap.get(name);
           //2.deleting all the movies from the moviesdb by using movieName
           for(String movie: movies){
               if (movieMap.containsKey(movie)) {
                   movieMap.remove(movie);
               }
           }
           //3.deleting the pair
           movieDirectorMap.remove(name);
       }
       //4.delete the director from directordb
       if(directorMap.containsKey(name)){
           directorMap.remove(name);
       }
    }


}
