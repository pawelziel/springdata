package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;



    public List<Movie> getAllMovies() {
        movieRepository.deleteNotNominated();
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(int id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    public Movie changeMovie(Movie movie) {

        return movieRepository.save(movie);
    }

    public void delMovie(int id) {
        movieRepository.deleteById(id);
    }

    public void addMovies(List<Movie> movies) {
        movieRepository.saveAll(movies);
    }
}
