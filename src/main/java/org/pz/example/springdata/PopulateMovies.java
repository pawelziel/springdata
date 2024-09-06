package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class PopulateMovies implements ApplicationRunner {
    private final MovieDao movieDao;

    @Override
    public void run(ApplicationArguments args) {
        movieDao.addMovie(new Movie(1, "Titanic", "20th Century Studios", "James Cameron", LocalDate.of(1997, 12, 19), 13));
        movieDao.addMovie(new Movie(2, "Titanic2", "20th Century Studios", "James Cameron", LocalDate.of(1997, 12, 19), 13));
        movieDao.addMovie(new Movie(3, "Titan", "20th Century Studios", "Jasiek Cameron", LocalDate.of(1997, 12, 19), 13));
    }
}