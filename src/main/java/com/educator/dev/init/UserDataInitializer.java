package com.educator.dev.init;
import com.educator.auth.AuthService;
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

    private final AuthService authService;

    @PostConstruct
    public void initializeUserData () {
        userRepository.save(authService.getLoggedUser());
    }
}
