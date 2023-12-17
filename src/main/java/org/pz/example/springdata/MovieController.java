package org.pz.example.springdata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
