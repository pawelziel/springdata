package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getFromRepoo();
    }

    @GetMapping(path = "/{id}")
    public  Movie getMovie(@PathVariable int id) {
        return movieService.getFromRepoo(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieService.delete(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie m) {
        movieService.addMovie(m);
    }

}
