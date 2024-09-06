package org.pz.example.springdata;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select m from Movie m where m.title = ?1")
    Optional<Movie> znajdzPoTytule(String title);

    List<Movie> findByReleaseDate(LocalDate date);

    List<Movie> findByDirectorAndProducer(String director, String producer);

    List<Movie> findAllByOrderByOscarNominations();

    @Query("select m FROM Movie where m.oscarNominations>10")
    List<Movie> znajdzTylkoFajneFilmy();

    List<Movie> findAllByTitleLikeOrderByOscarNominations(String title);


    List<Movie> findByDirector(String director, Pageable pageable);


}
