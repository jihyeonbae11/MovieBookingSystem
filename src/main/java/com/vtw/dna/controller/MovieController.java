package com.vtw.dna.controller;

import com.vtw.dna.entity.Booking;
import com.vtw.dna.entity.Movie;
import com.vtw.dna.service.BookingService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Setter(onMethod_ = @Autowired)
    private BookingService bookingService;

    // 전체 영화정보
    @GetMapping
    public List<Movie> allMovieInfo() throws Exception {

        List<Movie> movieList = bookingService.getAllMovie();
        return movieList;
    }

    // 장르별 영화정보
    @GetMapping(value="/{genre}")
    public List<Movie> genreMovieInfo(@PathVariable String genre) throws Exception {

        List<Movie> movieList = bookingService.findGenreMovie(genre);
        return movieList;
    }



}
