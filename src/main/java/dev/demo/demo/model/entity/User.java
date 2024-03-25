package dev.demo.demo.model.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password_hash;
    private String email;
    private Boolean is_active;
    private Boolean is_admin;
    private Timestamp created_time;
    private Timestamp last_login;
}
