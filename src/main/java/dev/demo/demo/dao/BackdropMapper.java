package dev.demo.demo.dao;
import dev.demo.demo.model.entity.Backdrop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BackdropMapper {
    @Select({"SELECT image_url FROM backdrop WHERE imdb_id = #{imdb}"})
    List<String> getAllBackdropsByImdb(String imdb);

    @Select({"SELECT image_url FROM backdrop WHERE imdb_id = #{imdb} LIMIT 1;"})
    String getFirstBackdropByImdb(String imdb);

    @Insert("<script>" +
            "INSERT INTO backdrop (image_url, imdb_id) VALUES " +
            "<foreach collection='backdrops' item='item' separator=',' > " +
            "(#{item.imageUrl}, #{item.imdbId}) " +
            "</foreach> " +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNewBackdrops(@Param("backdrops") List<Backdrop> backdrops);

    @Delete({"DELETE FROM backdrop WHERE imdb_id = #{imdb}"})
    void deleteBackdropByImdb(String imdb);
}
