package dev.demo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendVerifingEmail(String sendTo, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(sendTo);
			helper.setSubject(subject);
			helper.setText(body);
			mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
