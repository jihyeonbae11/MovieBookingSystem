package com.vtw.dna.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Movie extends CommonDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false, length = 100)
    private String movieName;

    @Column(nullable = false, length = 100)
    private String director;

    @Column(nullable = true, length = 100)
    private String genre;

    @Column(nullable = false, length = 100)
    private String viewingLevel;

}
