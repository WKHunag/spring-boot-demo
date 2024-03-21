package dev.demo.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.demo.demo.model.dto.UserLogin;
import dev.demo.demo.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/api/v1")
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> UserRegister(UserLogin req) {
        if (service.UserRegister(req)) {
            return new ResponseEntity<>("Regist successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Already registed.", HttpStatus.OK);
    };
}
