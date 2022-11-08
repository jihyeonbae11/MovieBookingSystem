package com.vtw.dna.repository;

import com.vtw.dna.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // 장르별 영화 list 조회를 위한 메소드
    List<Movie> findByGenre(String genre);

    // 영화 ID로 영화 조회를 위한 메소드
    Movie findByMovieId(long movieId);

}
