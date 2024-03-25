package dev.demo.demo.service;

import java.time.Duration;
import java.util.Random;

import org.springframework.data.redis.core.StringRedisTemplate;

public class OtpService {
    private final StringRedisTemplate redisTemplate;
    private final int OTP_EXPIRATION_SECONDS = 300; // 5 minutes

    public OtpService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generateRandomOtp() {
        Random r = new Random();
        String otp = String.format("%06d", r.nextInt(100000));
        return otp;
    }

    public String generateOtp(String email) {
        String otp = generateRandomOtp(); // Implement OTP generation logic
        String key = "otp:" + email;
        redisTemplate.opsForValue().set(key, otp, Duration.ofSeconds(OTP_EXPIRATION_SECONDS));
        return otp;
    }

    public boolean verifyOtp(String email, String userOtp) {
        String key = "otp:" + email;
        String storedOtp = redisTemplate.opsForValue().get(key);
        boolean isValid = storedOtp != null && storedOtp.equals(userOtp);
        if (isValid) {
            redisTemplate.delete(key);
        }
        return isValid;
    }
}
