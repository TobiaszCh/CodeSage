package com.educator.auth;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new CodeSageRuntimeException("Nie ma informacji o zalogowanym użytkowniku");
        }
        Object userObject = authentication.getPrincipal();
        if (userObject instanceof User) {
            return (User) userObject;
        } else {
            throw new CodeSageRuntimeException("Instancja tego obiektu jest inna od User");
        }
    }
}
