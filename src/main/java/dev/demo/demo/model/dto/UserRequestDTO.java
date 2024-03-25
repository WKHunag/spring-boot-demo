package dev.demo.demo.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRequestDTO {
    private String username;
    private String password;
    private String email;
}   
