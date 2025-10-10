package com.educator.auth;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new CodeSageRuntimeException("No authenticated user found in the security context");
        }
        Object userObject = authentication.getPrincipal();
        if (userObject instanceof User) {
            return (User) userObject;
        } else {
            throw new CodeSageRuntimeException("Authenticated principal is not type of User");
        }
    }

    public static User getLoggedAdmin() {
        return new User(2L, "ADMIN","sdfsf", true, Role.ADMIN, "Nothing", 0);

    }

}
