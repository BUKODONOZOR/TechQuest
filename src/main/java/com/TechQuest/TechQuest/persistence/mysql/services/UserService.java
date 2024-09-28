package com.TechQuest.TechQuest.persistence.mysql.services;

import com.TechQuest.TechQuest.persistence.mysql.dtos.UserLoginDTO;
import com.TechQuest.TechQuest.persistence.mysql.dtos.UserRegisterDTO;
import com.TechQuest.TechQuest.persistence.mysql.entity.User;
import com.TechQuest.TechQuest.persistence.mysql.repository.UserRepository;
import com.TechQuest.TechQuest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User register(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setName(userRegisterDTO.getName());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setRole(userRegisterDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setLastModifiedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public String login(UserLoginDTO userLoginDTO) throws Exception {
        User user = userRepository.findByEmail(userLoginDTO.getEmail());

        if (user == null || !passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            throw new Exception("Invalid email or password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
