package dev.demo.demo.model.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private Long id;
    private String username;
    private String passwordHash;
    private String email;
    private Boolean isActive;
    private Boolean isAdmin;
    private Timestamp createdTime;
}
