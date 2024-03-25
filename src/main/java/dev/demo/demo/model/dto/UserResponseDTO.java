package dev.demo.demo.model.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private boolean verified;
    private String message;
}
