package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class PopulateMovies implements ApplicationRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) {
//        movieRepository.save(new Movie(1, "Titanic", "20th century studios", "James Cameron", LocalDate.of(1997, 12, 19), 13));
//        movieRepository.save(new Movie(2, "Titanic2", "WarnerBros", "James Cameron", LocalDate.of(1997, 12, 19), 7));
//        movieRepository.save(new Movie(3, "Titan", "20th Century Studios", "Jasiek Cameron", LocalDate.of(1997, 12, 19), 13));
    }
}