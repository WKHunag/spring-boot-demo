package dev.demo.demo.service;

import dev.demo.demo.dao.MovieMapper;
import dev.demo.demo.model.Backdrop;
import dev.demo.demo.model.GenreToMovie;
import dev.demo.demo.model.Movie;
import dev.demo.demo.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieMapper mapper;

    public Map<String, Movie> getAllMovies() {
        return mapper.getAllMovies();
    }

    public List<String> getBackdropsByImdb(String imdb) {
        return mapper.getAllBackdropsByImdb(imdb);
    }

    public List<String> getReviewsByImdb(String imdb) {
        return mapper.getAllReviewsByImdb(imdb);
    }

    public List<GenreToMovie> getAllGenres() {
        return mapper.getAllGenres();
    }
}
