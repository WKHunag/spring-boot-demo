package dev.demo.demo.dao;

import dev.demo.demo.model.Content;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContentMapper {
    @Select({"SELECT * FROM content WHERE id = #{id}" })
    Content getContentById(Long id);
}