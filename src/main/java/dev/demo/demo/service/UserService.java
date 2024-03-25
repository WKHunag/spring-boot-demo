package dev.demo.demo.service;

import java.util.Random;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private final PasswordEncoder passwordEncoder;

    public User getUserByEmail(String email) {
        return mapper.getUserByEmail(email);
    }

    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    public UserResponseDTO registerUser(UserRequestDTO req) {
        UserResponseDTO res = new UserResponseDTO();
        
        boolean user = mapper.existByUsername(req.getUsername());
        if (user) {
            res.setMessage("User already registered.");
        } else {
			String otp = otpService.generateOtp(req.getEmail());
			
			User newUser = new User();
			newUser.setUsername(req.getUsername());
            String password_hash = passwordEncoder.encode(req.getPassword());
            newUser.setPassword_hash(password_hash);
			newUser.setEmail(req.getEmail());
			newUser.setIs_active(false);
			
            mapper.insertUser(newUser);
            String subject = "Email Verfication";
            String body = "Verify your account via the url: localhost:8080/verify-user/" + req.getEmail() + "/" + otp;
            //Email Send
            this.emailService.sendVerifingEmail(req.getEmail(), subject, body);
            
            res.setUsername(req.getUsername());
            res.setEmail(req.getEmail());
            res.setMessage("OTP sent successfully!");
		}
		
		return res;
    }
}
