package dev.demo.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dev.demo.demo.model.dto.UserLogin;
import dev.demo.demo.model.entity.User;
import io.micrometer.common.lang.Nullable;

@Mapper
public interface UserMapper {
    @Select({"SELECT * FROM user"+
            " WHERE (username = #{username} or email = #{email})"})
    public UserLogin getUserByUsernameOrEmail(@Nullable String username, @Nullable String email);

    @Insert({"INSERT INTO user (usename, password, email)"+
            " VALUE (#{usename}, #{password}, #{email})"})
    public void UserRegister(User user);

    @Select({"SELECT SOUNT(*) FROM user" + 
            " WHERE email = #{email};"})
    public int ifExist(String email);
}
