package com.educator.auth;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import com.educator.core.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthService  {

    private final UserRepository userRepository;

    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new CodeSageRuntimeException("No authenticated user found in the security context");
        }
        Object userObject = authentication.getPrincipal();
        if (userObject instanceof User) {
            return (User) userObject;
        } else if (userObject instanceof OAuth2User) {
            String email = ((OAuth2User) userObject).getAttribute("email");
            return userRepository.findByUsername(email).orElseThrow(
                    () -> new CodeSageRuntimeException("This user doesn't exist"));
        } else {
            throw new CodeSageRuntimeException("Authenticated principal is not type of User and OAuth2User");
        }
    }
    public boolean isUserLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object userObject = authentication.getPrincipal();
        return userObject instanceof User || userObject instanceof OAuth2User;
    }

    public static User getLoggedAdmin() {
        return new User(2L, "ADMIN","sdfsf", true, Role.ADMIN, "Nothing", 0);
    }

}
