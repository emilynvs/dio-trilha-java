package dio.projeto_spring.controller;

import dio.projeto_spring.model.Movie;
import dio.projeto_spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public Movie saveMovie(@Validated @RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies")
    public List<Movie> fetchMovie(){
        return movieService.fetchMovieList();
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("id") Long movieId){
        return movieService.updateMovie(movie, movieId);
    }

    @DeleteMapping("/movies/{id}")
    public String deleteMovieById(@PathVariable("id") Long movieId){
        movieService.deleteMovieById(movieId);
        return "Deleted Successfully";
    }
}
