package org.pz.example.springdata;

import java.util.List;

public interface MovieDao {
    void addMovie(Movie movie);

    void deleteMovie(int id);

    List<Movie> getAllMovies();
}
