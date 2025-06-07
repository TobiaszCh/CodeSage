package com.educator.controller;

import com.educator.core.user.UserService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    public final AuthenticationManager manager;

    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession(true);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerDetails(@Valid @RequestBody RegisterDto registerDto) {
        userService.registerDetails(registerDto);
        return ResponseEntity.ok(Map.of("message","Rejestracja wykonana pomyślnie"));
    }
}
