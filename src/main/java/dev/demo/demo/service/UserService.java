package dev.demo.demo.service;

import org.springframework.stereotype.Service;

import dev.demo.demo.dao.UserMapper;
import dev.demo.demo.model.dto.UserLogin;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    
    public boolean UserRegister(UserLogin req) { 
        if (mapper.ifExist(req.getUser().getEmail()) == 1) {
            mapper.UserRegister(req.getUser());
            return true;
        }
        return false;
    }
}
