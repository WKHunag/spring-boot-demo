package dev.demo.demo.dao;

import dev.demo.demo.model.dto.MovieDTO;
import dev.demo.demo.model.entity.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MovieMapper {

    @Select({"SELECT * FROM movie "})
    @Results(
            {@Result(column = "imdb_id", property = "imdbId"),
                    @Result(column = "trailer_link", property = "trailerLink"),
                    @Result(column = "released_date", property = "releasedDate")})
    List<MovieDTO> getAllMovies();

    @Insert({"INSERT INTO movie (imdb_id, title, trailer_link, poster, released_date)"+
            " VALUES (#{imdbId}, #{title}, #{trailerLink}, #{poster}, #{releasedDate});"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNewMovie(Movie movie);

    @Delete({"DELETE FROM movie WHERE imdb_id = #{imdbId};"})
    void deleteMovie(String imdbId);

}
