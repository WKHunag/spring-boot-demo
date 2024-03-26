package dev.demo.demo.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.demo.demo.model.dto.UserRequestDTO;
import dev.demo.demo.model.dto.UserResponseDTO;
import dev.demo.demo.model.entity.User;
import dev.demo.demo.service.OtpService;
import dev.demo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/users/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OtpService otpService;

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO req) {
        UserResponseDTO res = userService.registerUser(req);
        if (res.getCode() == "0000") {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().body(res);
    }

    @GetMapping("/verify-user/{email}/{otp}")
    public ResponseEntity<String> verifyUser(@PathVariable String email, @PathVariable String otp) {
        email = URLDecoder.decode(email, StandardCharsets.UTF_8);
        otp = URLDecoder.decode(otp, StandardCharsets.UTF_8);
        boolean isValid = otpService.verifyOtp(email, otp);
        if (isValid) {
            // OTP is valid, activate the user account
            User user = userService.getUserByEmail(email);
            user.setIsActive(true);
            userService.updateUser(user);
            return ResponseEntity.ok("Account activated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired OTP");
        }
    }
}
