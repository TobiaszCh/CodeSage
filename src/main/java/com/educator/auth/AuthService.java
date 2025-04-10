package com.educator.auth;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public User getLoggedUser() {
        return new User(-69L, "TestUser", "fdcsc", true,Role.USER, "beginner", 0);
    }
}
