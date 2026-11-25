package com.educator.controller;

import com.educator.auth.AuthService;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.UserService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import com.educator.core.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginDto loginDto) {
        userService.login(loginDto);
        return ResponseEntity.ok(Map.of("message", "Zalogowano pomyślnie"));
    }

    //TODO extract private method
    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request, HttpServletResponse response) {
        if (request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                //TODO Magic String
                Cookie deleteCookie = new Cookie("JSESSIONID", "");
                deleteCookie.setSecure(true);
                deleteCookie.setMaxAge(0);
                response.addCookie(deleteCookie);

            } else {
                throw new CodeSageRuntimeException("Session doesn't have value. Object is null");
            }
        } else {
            throw new CodeSageRuntimeException("Request doesn't have value. HttpServletRequest is null");
        }
        return ResponseEntity.ok(Map.of("message", "Wylogowano pomyślnie"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerDetails(@Valid @RequestBody RegisterDto registerDto) {
        userService.registerDetails(registerDto);
        return ResponseEntity.ok(Map.of("message", "Rejestracja wykonana pomyślnie"));
    }

    @GetMapping("/me")
    public ResponseEntity<Boolean> isUserLoggedIn() {
        return ResponseEntity.ok(authService.isUserLoggedIn());
    }

    @GetMapping
    public UserDto getUserProfile() {
        return userService.getUser();
    }

    @PostMapping("/random-register")
    public ResponseEntity<Map<String, String>> createRandomUser() {
        userService.createRandomUser();
        return ResponseEntity.ok(Map.of("message", "Rejestracja wykonana pomyślnie"));
    }

}
