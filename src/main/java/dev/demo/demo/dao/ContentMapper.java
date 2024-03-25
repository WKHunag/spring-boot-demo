package dev.demo.demo.dao;

import dev.demo.demo.model.entity.Content;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContentMapper {
    @Select({"SELECT * FROM content WHERE id = #{id}" })
    Content getContentById(Long id);

    @Select({"SELECT * FROM content"})
    List<Content> getAllContent();
}