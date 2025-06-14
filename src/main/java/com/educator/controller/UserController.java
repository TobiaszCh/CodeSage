package com.educator.controller;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.UserService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.CookieStore;
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

    @PostMapping("/logout")
    public ResponseEntity<Map<String,String>> logout(HttpServletRequest request, HttpServletResponse response) {
        if(request != null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                Cookie deleteCookie = new Cookie("JSESSIONID", "");
                deleteCookie.setMaxAge(0);
                response.addCookie(deleteCookie);

            } else {
                throw new CodeSageRuntimeException("Sesja nie istnieje");
            }
        } else {
            throw new CodeSageRuntimeException("Serwer nie dostał szczegółowych informacji o żądaniu");
        }
        return ResponseEntity.ok(Map.of("message","Wylogowanie wykonane pomyślnie"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerDetails(@Valid @RequestBody RegisterDto registerDto) {
        userService.registerDetails(registerDto);
        return ResponseEntity.ok(Map.of("message","Rejestracja wykonana pomyślnie"));
    }
}
