package org.pz.example.springdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class MovieDaoImpl implements MovieDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public void deleteMovie(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        if (movie !=null)
            entityManager.remove(movie);
    }

    @Override
    public List<Movie> getAllMovies(Movie movie) {
        return entityManager.createQuery("from Movie", Movie.class).getResultList();
    }
}
