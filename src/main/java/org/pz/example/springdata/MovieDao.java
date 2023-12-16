package org.pz.example.springdata;

import java.util.List;

public interface MovieDao {
    public void addMovie(Movie m);

    public void deleteMovieint(int id);

    public List<Movie> getAll();

}
