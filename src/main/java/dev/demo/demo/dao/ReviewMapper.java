package dev.demo.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {
    @Select({"SELECT content FROM review WHERE imdb_id = #{imdb};"})
    List<String> getAllReviewsByImdb(String imdb);
}
