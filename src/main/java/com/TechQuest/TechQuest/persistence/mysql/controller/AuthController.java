package com.TechQuest.TechQuest.persistence.mysql.controller;

import com.TechQuest.TechQuest.persistence.mysql.dtos.UserLoginDTO;
import com.TechQuest.TechQuest.persistence.mysql.dtos.UserRegisterDTO;
import com.TechQuest.TechQuest.persistence.mysql.entity.User;
import com.TechQuest.TechQuest.persistence.mysql.services.UserService;
import com.TechQuest.TechQuest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            userService.register(userRegisterDTO);  // Registrar el usuario
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            // Evita recursión accidental aquí
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect credentials");
        }

        // Generar token JWT después de la autenticación exitosa
        String token = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}

