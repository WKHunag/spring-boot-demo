package dev.demo.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dev.demo.demo.model.entity.User;

@Mapper
public interface UserMapper {
    @Select({"SELECT COUNT(*) FROM user WHERE username = #{username}"})
    public boolean existByUsername(String name);

    @Select({"SELECT * FROM user WHERE email = #{email}"})
    public User getUserByEmail(String email);

    @Insert("INSERT INTO user (username, password, email) " +
            "VALUES (#{username}, #{password}, #{email})")
    void insertUser(User user);

    @Update("UPDATE users SET is_active = #{is_active} WHERE email = #{email}")
    void updateUser(User user);
}
