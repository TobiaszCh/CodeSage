package com.educator.auth;
import com.educator.core.user.User;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public User getLoggedUser() {
        return new User(-69L, "TestUser", "beginner", 0);
    }
}
