package org.pz.example.springdata;


import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface MovieRepository extends JpaRepository<Movie, Integer> , JpaSpecificationExecutor<Movie> {



    List<Movie> findByTitleLikeOrderByOscarNominationsDesc(String title);


    @Query("select m from Movie m where m.producer = ?1 and m.director = ?2")
    List<Movie> findByProducerAndDirector(String producer, String director);

    List<Movie> findTop12AllByOrderByReleaseDateDesc();


    @Query("select m from Movie m where m.title = :tytul")
    List<Movie> znajdzNaPodstawieTytulu(@Param("tytul") String t);

    @Modifying
    @Query(value = "delete FROM Movie m WHERE m.oscar_nominations=0", nativeQuery = true)
    void deleteNotNominated();


    Page<Movie> findAll(Pageable pageable);


    List<Movie> findAll();
}
