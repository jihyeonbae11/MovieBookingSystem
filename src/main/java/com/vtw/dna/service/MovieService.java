package com.vtw.dna.service;

import com.vtw.dna.entity.Movie;
import com.vtw.dna.repository.BookingRepository;
import com.vtw.dna.repository.MovieRepository;
import com.vtw.dna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    // 영화 제목으로 조회
    public Page<Movie> findMovies(Pageable pageable, String searchName) {
        return movieRepository.findAllByMovieNameContains(pageable, searchName);
    }

    // 장르별 영화 리스트 조회
    public List<Movie> findGenreMovies(String genre) {
        return Optional.ofNullable(movieRepository.findByGenre(genre)).orElseThrow(NullPointerException::new);
    }

    // 영화 ID로 영화를 조회
    public Movie findMovie(Long movieId) {
        return Optional.ofNullable(movieRepository.findByMovieId(movieId)).orElseThrow(NullPointerException::new);
    }

}
