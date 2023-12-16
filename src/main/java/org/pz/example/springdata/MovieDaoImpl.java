package org.pz.example.springdata;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addMovie(Movie m) {
        em.persist(m);
    }

    @Override
    public void deleteMovieint(int id) {
        Movie m = em.find(Movie.class, id);
        if (m !=null)
            em.remove(m);
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> listMocies = em.createQuery("from Movie", Movie.class).getResultList();
        return listMocies;
    }
}
