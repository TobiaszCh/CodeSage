package com.educator.dev.init;

import com.educator.core.user.User;
import com.educator.core.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
@Component
@AllArgsConstructor
@Profile("development")
public class UserDataInitializer {

    private final UserRepository userRepository;

    @PostConstruct
    public void initializeUserData () {
        userRepository.save(new User(69L, "TestUser", "beginner", 0));

    }
}
