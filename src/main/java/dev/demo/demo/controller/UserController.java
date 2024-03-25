package dev.demo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.demo.demo.model.entity.User;
import dev.demo.demo.service.OtpService;
import dev.demo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/users/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OtpService otpService;

    @GetMapping("/verify-user/{email}/{otp}")
    public ResponseEntity<String> verifyUser(@PathVariable String email, @PathVariable String otp) {
        boolean isValid = otpService.verifyOtp(email, otp);
    if (isValid) {
        // OTP is valid, activate the user account
        User user = userService.getUserByEmail(email);
        user.setIs_active(true);
        userService.updateUser(user);
        return ResponseEntity.ok("Account activated successfully");
    } else {
        return ResponseEntity.badRequest().body("Invalid or expired OTP");
    }
    }
}
