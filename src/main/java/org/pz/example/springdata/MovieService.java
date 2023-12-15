package org.pz.example.springdata;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void movieOperations() {
        Movie movie = new Movie();
        movieRepository.save(movie);
        movieRepository.findAll();
        movieRepository.delete(movie);
        movieRepository.deleteAll();
    }

    public void processAllMovies() {
        List<Movie> movieList = movieRepository.findAll();

        for (Movie movie : movieList) {
            // ...
        }
    }

    public List<Movie> processAllMoviesInOrderOfNominations() {
        List<Movie> movieList =  movieRepository.findAll(Sort.by(Sort.Direction.DESC, "oscarNominations"));
        for (Movie movie : movieList) {
            // ...
        }
        return movieList;
    }

    public Page<Movie> findPageOfMoviesLike(String title, int pageNumber, int pageSize) {
        return movieRepository.findByTitleLike(title, PageRequest.of(pageNumber, pageSize));
    }

    public List<Movie> findMoviesDirectedByWoodyAllen() {
        Movie exampleMovie = new Movie();
        exampleMovie.setDirector("WoodyAllen");
        return movieRepository.findAll(Example.of(exampleMovie));
    }

    public List<Movie> findMoviesByWarnerBros() {
        Movie exampleMovie = new Movie();
        exampleMovie.setProducer("WarnerBros");
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        return movieRepository.findAll(Example.of(exampleMovie, matcher));
    }


    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }



    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        List<Movie> results = movieRepository.findAll(
                MovieSpecification.releasedBefore(LocalDate.now())
                        .and(MovieSpecification.hasTitle("Titan"))
                );

    }




}
