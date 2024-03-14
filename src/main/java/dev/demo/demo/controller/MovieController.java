package dev.demo.demo.controller;

import dev.demo.demo.model.dto.DeleteMovieReqDTO;
import dev.demo.demo.model.dto.MovieDTO;
import dev.demo.demo.model.dto.NewMovieReqDTO;
import dev.demo.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie/api")
public class MovieController {
    private final MovieService movieservice;

    @GetMapping("/v1/all-movies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return new ResponseEntity<>(movieservice.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping("/v1/add/movie")
    public ResponseEntity<String> pushNewMovie(@RequestBody NewMovieReqDTO req) {
        movieservice.NewMovieInsert(req);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/movie/{imdbId}")
    public ResponseEntity<String> deleteMovie(@PathVariable String imdbId) {
        DeleteMovieReqDTO req = new DeleteMovieReqDTO(imdbId);
        movieservice.DeleteMovie(req);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
