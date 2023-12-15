package org.pz.example.springdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie> {

    Optional<Movie> findByTitle(String title);
  
    List<Movie> findByTitleLike(String title);
    List<Movie> findByReleaseDateBefore(LocalDate releaseDate);
    List<Movie> findByProducerAndDirector(String producer, String director);
    List<Movie> findAllByOrderByOscarNominationsDesc();
    // ...
    @Query("select m FROM Movie m WHERE m.oscarNominations = :nominations")
    List<Movie> findMoviesNominatedTimes(@Param("nominations") int nominations);

    @Query(value = "select * FROM Movie m WHERE m.oscarNominations = :nominations", nativeQuery = true)
    List<Movie> findMoviesNominatedTimesNative(@Param("nominations") int nominations);


    @Modifying
    @Query("update Movie m SET m.oscarNominations = 0" )
    public void resetAllNominations();

    @Modifying
    @Query(value="delete FROM Movie m WHERE oscarNominations = 0", nativeQuery=true)
    public void removeNeverNominated();



    Page<Movie> findByTitleLike(String title, Pageable pageable);
}
// https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
