package dev.demo.demo.dao;

import ch.qos.logback.core.joran.sanity.Pair;
import dev.demo.demo.model.entity.GenreToMovie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GenreToMovieMapper {
    @Select({"SELECT name FROM genretomovie WHERE imdbId = #{imdb}"})
    List<String> getAllGenresByImdb(String imdb);

    @Select({"SELECT name, definition FROM genretomovie WHERE id = #{id}"})
    Pair<String, String> getGenreById(Long id);

    @Insert({"<script>",
            " INSERT INTO genretomovie (name, definition, imdbId, created_date, updated_date) VALUES " +
            " <foreach collection='genres' item='item' separator=',' > " +
            " (#{item.name}, #{item.definition}, #{item.imdbId}, #{item.createdDate}, #{item.updatedDate}) ",
            "</foreach>",
            "</script>"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNewGenre(@Param("genres") List<GenreToMovie> genres);

    @Delete({"DELETE FROM genretomovie WHERE imdbId = #{imdbId}"})
    void deleteGenreByImdb(String imdbId);
}
