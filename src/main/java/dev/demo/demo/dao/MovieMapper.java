package dev.demo.demo.dao;

import dev.demo.demo.model.Backdrop;
import dev.demo.demo.model.GenreToMovie;
import dev.demo.demo.model.Movie;
import dev.demo.demo.model.Review;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface MovieMapper {

    @Select({"SELECT * FROM movie " +
            "LEFT JOIN backdrop ON movie.imdbId = backdrop.imdb;"})
    @Results(id = "movieResult", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "imdbId", column = "imdbId"),
            @Result(property = "title", column = "title"),
            @Result(property = "trailerLink", column = "trailerLink"),
            @Result(property = "poster", column = "poster"),
            @Result(property = "backdrops", column = "imdb", javaType = List.class,
                many = @Many(select = "getAllBackdropsByImdb")),
            @Result(property = "reviews", column="imdb", javaType = List.class,
                many = @Many(select = "getAllReviewsByImdb"))
    })
    @MapKey("imdbId")
    Map<String, Movie> getAllMovies();

    @Select({"SELECT image_url FROM backdrop WHERE imdb = #{imdb}"})
    List<String> getAllBackdropsByImdb(String imdb);

    @Select({"SELECT content FROM review WHERE imdb = #{imdb}"})
    List<String> getAllReviewsByImdb(String imdb);

    @Select({"SELECT * FROM genretomovie;"})
    List<GenreToMovie> getAllGenres();

    @Select({"SELECT movie.* FROM genretomovie " +
            "LEFT JOIN movie on genretomovie.imdb = movie.imdbId"})
    List<Movie> getMoviesByGenre();

}
