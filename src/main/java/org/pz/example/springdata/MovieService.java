package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getFromRepoByExaple() {
        Movie exampleMovie = new Movie();
        exampleMovie.setProducer("20th Century Studios");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Movie> example = Example.of(exampleMovie, exampleMatcher);
        return movieRepository.findAll(example, Sort.by("title"));
    }

    public List<Movie> getFromRepoBySpec() {
    return movieRepository.findAll(
                MovieSpecification.jestFajny().or(MovieSpecification.directorLike("James%").and(MovieSpecification.sortedByTitle()))
        );
    }

}
