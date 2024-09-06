package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getFromRepoo() {
       // return movieDao.getAll();
       // return movieRepository.findAll();
      //  return movieRepository.findAll(PageRequest.of(1, 2));
        return movieRepository.findByDirector("James Cameron", PageRequest.of(0, 2));
    }

}
