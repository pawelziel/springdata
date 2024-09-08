package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;



    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delMovie(@PathVariable int id) {
        movieService.delMovie(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PostMapping("multiple")
    public void addMovies(@RequestBody List<Movie> movies) {
        movieService.addMovies(movies);
    }


    @PutMapping
    public Movie changeMovie(@RequestBody Movie movie) {
        return movieService.changeMovie(movie);
    }



}
