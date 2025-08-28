package dio.projeto_spring.repository;

import dio.projeto_spring.model.Movie;
import dio.projeto_spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ImplMovieRepository implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> fetchMovieList() {
        return (List<Movie>)
                movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie, Long movieId) {
        Movie mov = movieRepository.findById(movieId).get();

        if(Objects.nonNull(movie.getComents())
        && !"".equalsIgnoreCase(
                movie.getComents())){
            mov.setComents(
                    movie.getComents()
            );
        }

        if(movie.getAvaliation() > 0){
            mov.setAvaliation(movie.getAvaliation());
        }

        return movieRepository.save(mov);
    }

    @Override
    public void deleteMovieById(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
