package com.educator.controller;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.UserService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginDto loginDto, HttpServletRequest request) {
        SecurityContextHolder.getContext().setAuthentication(userService.authenticate(loginDto));
        request.getSession(true);
        return ResponseEntity.ok(Map.of("message","Logowanie wykonane pomyślnie"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerDetails(@Valid @RequestBody RegisterDto registerDto) {
        userService.registerDetails(registerDto);
        return ResponseEntity.ok(Map.of("message","Rejestracja wykonana pomyślnie"));
    }
}
