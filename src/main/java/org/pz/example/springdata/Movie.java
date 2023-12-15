package org.pz.example.springdata;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Movie { //create table MOVIE (
    @Id
    private Integer id; // ID int NOT NULL AUTO_INCREMENT,

    private String title; // TITLE varchar(255),

    private String producer; // PRODUCER varchar(255),

    private String director; // DIRECTOR varchar(255),

    private LocalDate releaseDate; // RELASE_DATE varchar(255),

    private Integer oscarNominations; // OSCAR_NOMINATIONS int, PRIMARY KEY (ID));

}
