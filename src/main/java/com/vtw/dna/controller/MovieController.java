package com.vtw.dna.controller;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.Movie;
import com.vtw.dna.service.BookingService;
import com.vtw.dna.service.MovieService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Setter(onMethod_ = @Autowired)
    private MovieService movieService;

    // 전체 영화정보
    @GetMapping
    public List<Movie> allMoviesInfo() throws Exception {

        List<Movie> movieList = movieService.getAllMovies();
        return movieList;
    }

    // 장르별 영화정보
    @GetMapping(value = "/genre")
    public List<Movie> genreMoviesInfo(@RequestParam(required = false) String genre) throws Exception {

        List<Movie> movieList = movieService.findGenreMovies(genre);
        return movieList;
    }



}
