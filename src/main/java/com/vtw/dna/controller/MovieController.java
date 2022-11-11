package com.vtw.dna.controller;

import com.vtw.dna.entity.Movie;
import com.vtw.dna.service.MovieService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Setter(onMethod_ = @Autowired)
    private MovieService movieService;

    // 전체 영화정보
    @GetMapping
    public Page<Movie> list(@RequestParam("page") int page,
                            @RequestParam("size") int size,
                            @RequestParam(value = "sortBy", defaultValue = "movieId") String sortBy,
                            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir,
                            @RequestParam(value = "filter", defaultValue = "") String filter) throws Exception {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        Page<Movie> movies = movieService.findMovies(pageable, filter);

        return movies;
    }

//    @GetMapping("/{movieId}")
//    public Movie find(@PathVariable Long movieId) {
//        Movie movie = movieService.findMovie(movieId);
//        return movie;
//    }


    // 장르별 영화정보
//    @GetMapping(value = "/sort")
//    public List<Movie> genreMoviesInfo(@RequestParam(required = false) String genre) throws Exception {
//
//        List<Movie> movieList = movieService.findGenreMovies(genre);
//        return movieList;
//    }



}
