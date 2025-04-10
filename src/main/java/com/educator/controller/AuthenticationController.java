package com.educator.controller;

import com.educator.core.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthenticationController {

    public final AuthenticationManager manager;
    @PostMapping("/login")
    public void login(@RequestBody UserDto userDto, HttpServletRequest request) {
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(userDto.username, userDto.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession(true);
    }
}
