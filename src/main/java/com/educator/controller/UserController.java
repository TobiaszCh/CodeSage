package com.educator.controller;

import com.educator.auth.AuthService;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.User;
import com.educator.core.user.UserService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import com.educator.core.user.dto.UsernameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://code-sage-front-a970cdb2bc71.herokuapp.com"}, allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@Valid @RequestBody LoginDto loginDto) {
        SecurityContextHolder.getContext().setAuthentication(userService.authenticate(loginDto));
        return ResponseEntity.ok(Map.of("message","Zalogowano pomyślnie"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String,String>> logout(HttpServletRequest request, HttpServletResponse response) {
        if(request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                Cookie deleteCookie = new Cookie("JSESSIONID", "");
                deleteCookie.setSecure(true);
                deleteCookie.setMaxAge(0);
                response.addCookie(deleteCookie);

            } else {
                throw new CodeSageRuntimeException("Session doesn't have value. Object is null");
            }
        } else {
            throw new CodeSageRuntimeException("Request doesn't have value. Object is null");
        }
        return ResponseEntity.ok(Map.of("message","Wylogowano pomyślnie"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerDetails(@Valid @RequestBody RegisterDto registerDto) {
        userService.registerDetails(registerDto);
        return ResponseEntity.ok(Map.of("message","Rejestracja wykonana pomyślnie"));
    }

    @GetMapping("/me")
    public ResponseEntity<Boolean> isUserLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof User) {
            return ResponseEntity.ok(true);
        }
        else {
            throw new CodeSageRuntimeException("No authenticated user found in the security context");
        }
    }

    @GetMapping("/username")
    public UsernameDto getUsername() {
        return userService.getUsername();
    }
}
