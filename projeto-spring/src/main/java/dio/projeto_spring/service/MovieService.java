package dio.projeto_spring.service;

import dio.projeto_spring.model.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);

    List<Movie> fetchMovieList();

    Movie updateMovie(Movie movie, Long movieId);

    void deleteMovieById(Long movieId);
}
