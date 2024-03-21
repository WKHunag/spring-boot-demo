package dev.demo.demo.model.dto;

import dev.demo.demo.model.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserLogin {
    User user;
}   
