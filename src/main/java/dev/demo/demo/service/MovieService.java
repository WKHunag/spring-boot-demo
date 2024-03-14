package dev.demo.demo.service;

import dev.demo.demo.dao.BackdropMapper;
import dev.demo.demo.dao.GenreToMovieMapper;
import dev.demo.demo.dao.MovieMapper;
import dev.demo.demo.model.dto.DeleteMovieReqDTO;
import dev.demo.demo.model.dto.MovieDTO;
import dev.demo.demo.model.dto.NewMovieReqDTO;
import dev.demo.demo.model.entity.Backdrop;
import dev.demo.demo.model.entity.GenreToMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieMapper moviemapper;
    private final BackdropMapper backdropmapper;
    private final GenreToMovieMapper genremapper;

    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movies = moviemapper.getAllMovies();
        for (MovieDTO movie: movies) {
            String backdropUrl = backdropmapper.getFirstBackdropByImdb(movie.getImdbId());
            movie.getBackdrops().add(backdropUrl);
        }
        return movies;
    }

    @Transactional(rollbackFor = Exception.class)
    public void NewMovieInsert(NewMovieReqDTO req) {
        moviemapper.insertNewMovie(req.getMovie());
        if (req.getBackdrops()!= null && !req.getBackdrops().isEmpty()) {
            List<Backdrop> backdrops = req.getBackdrops().stream()
                    .map(url -> new Backdrop(null, url, req.getMovie().getImdbId())).toList();
            backdropmapper.insertNewBackdrops(backdrops);
        }
        if (req.getGenres()!= null &&!req.getGenres().isEmpty()) {
            List<GenreToMovie> genres = req.getGenres().stream()
                    .map(name -> new GenreToMovie(null, req.getMovie().getImdbId(), name, null, "2024-03-11", "2024-3-11")).toList();
            genremapper.insertNewGenre(genres);
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public void DeleteMovie(DeleteMovieReqDTO req) {
        moviemapper.deleteMovie(req.getImdbId());
        backdropmapper.deleteBackdropByImdb(req.getImdbId());
        genremapper.deleteGenreByImdb(req.getImdbId());
    }
}
