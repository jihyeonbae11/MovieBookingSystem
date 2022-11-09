package com.vtw.dna.service;

import com.vtw.dna.entity.Movie;
import com.vtw.dna.repository.BookingRepository;
import com.vtw.dna.repository.MovieRepository;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private BookingRepository bookingRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    // 전체 영화 조회
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 장르별 영화 리스트 조회
    public List<Movie> findGenreMovies(String genre) {
        return Optional.ofNullable(movieRepository.findByGenre(genre)).orElseThrow(NullPointerException::new);
    }

    // 영화 ID로 영화를 조회
    public Movie findMovie(long movieId) {
        return Optional.ofNullable(movieRepository.findByMovieId(movieId)).orElseThrow(NullPointerException::new);
    }


}
