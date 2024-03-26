package dev.demo.demo.service;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import dev.demo.demo.dao.UserMapper;
import dev.demo.demo.model.dto.UserRequestDTO;
import dev.demo.demo.model.dto.UserResponseDTO;
import dev.demo.demo.model.entity.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final EmailService emailService;
    private final OtpService otpService;

    public User getUserByEmail(String email) {
        return mapper.getUserByEmail(email);
    }

    public User getUserByUsername(String username) {
        return mapper.getUserByUsername(username);
    }

    public void updateUser(User user) {
        mapper.updateIsActive(user);
    }

    public UserResponseDTO registerUser(UserRequestDTO req) {
        UserResponseDTO res = new UserResponseDTO();
        
        User user = mapper.getUserByUsername(req.getUsername());
        if (user != null && user.getIsActive()) {
            res.setCode("0001");
            res.setMessage("User already registered.");
            return res;
        } 
        try {
            String otp = otpService.generateOtp(req.getEmail());
            User newUser = new User();
            newUser.setUsername(req.getUsername());
            String password_hash = Hashing.sha256().hashString(req.getPassword(), StandardCharsets.UTF_8).toString();
            newUser.setPasswordHash(password_hash);
            newUser.setEmail(req.getEmail());
            newUser.setIsActive(false);
            
            mapper.insertUser(newUser);
            String subject = "Email Verfication";
            String body = "Verify your account via the url: localhost:8080/verify-user/" + URLEncoder.encode(req.getEmail(), StandardCharsets.UTF_8.toString()) + "/" + URLEncoder.encode(otp, StandardCharsets.UTF_8.toString());
            //Email Send
            this.emailService.sendVerifingEmail(req.getEmail(), subject, body);
            
            res.setCode("0000");
            res.setMessage("OTP sent successfully!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            res.setCode("0004");
            res.setMessage("Error occurred while sending verification email.");
        }
        return res;
    }
}
