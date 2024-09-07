package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;


    public Page<Movie> getFromRepo() {


        return movieRepository.findAll(PageRequest.of(0, 2));


    }
}
