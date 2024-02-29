package dev.demo.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.demo.demo.model.Backdrop;
import dev.demo.demo.model.GenreToMovie;
import dev.demo.demo.model.Movie;
import dev.demo.demo.model.Review;
import dev.demo.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.formatter.qual.Format;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie/api")
public class MovieController {
    private final MovieService movieservice;

    @GetMapping("/v1/all-movies")
    public ResponseEntity<Map<String, Movie>> getAllMovies() {
        return new ResponseEntity<>(movieservice.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/v1/backdrops/{imdb}")
    public ResponseEntity<List<String>> getBackdropsByImdb(@PathVariable String imdb) {
        return new ResponseEntity<>(movieservice.getBackdropsByImdb(imdb), HttpStatus.OK);
    }

    @GetMapping("/v1/reviews/{imdb}")
    public ResponseEntity<List<String>> getReviewsByImdb(@PathVariable String imdb) {
        return new ResponseEntity<>(movieservice.getReviewsByImdb(imdb), HttpStatus.OK);
    }

    @GetMapping("/v1/all-genres")
    public ResponseEntity<List<GenreToMovie>> getAllGenres() {
        return new ResponseEntity<>(movieservice.getAllGenres(), HttpStatus.OK);
    }
}
