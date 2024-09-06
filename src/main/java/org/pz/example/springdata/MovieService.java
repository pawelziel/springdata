package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieDao movieDao;
    private final MovieRepository movieRepository;

    public List<Movie> getFromDao() {
        return movieDao.getAllMovies();
    }

    public List<Movie> getFromRepoo() {
        return movieRepository.findAll();
    }


}
