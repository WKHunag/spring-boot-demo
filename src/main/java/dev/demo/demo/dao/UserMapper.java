package dev.demo.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dev.demo.demo.model.entity.User;

@Mapper
public interface UserMapper {
    @Select({"SELECT COUNT(*) FROM user WHERE username = #{username}"})
    boolean existByUsername(String name);

    @Select({"SELECT COUNT(*) FROM user WHERE email = #{email}"})
    boolean existByEmail(String email);

    @Select({"SELECT username, email, is_active FROM user WHERE username = #{username}"})
    User getUserByUsername(String username);

    @Select({"SELECT * FROM user WHERE email = #{email}"})
    public User getUserByEmail(String email);

    @Insert("INSERT INTO user (username, password_hash, email) " +
            "VALUES (#{username}, #{passwordHash}, #{email})")
    void insertUser(User user);

    @Update("UPDATE users SET is_active = #{is_active} WHERE email = #{email}")
    void updateIsActive(User user);
}
