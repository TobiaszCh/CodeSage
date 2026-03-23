package com.educator.core.user;

import com.educator.auth.AuthService;
import com.educator.core.course.FirstCourseCreator;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.outbox_event.OutboxEventService;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import com.educator.core.user.dto.UsernameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager manager;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthService authService;

    private final Random random = new Random();

    private final FirstCourseCreator firstCourseCreator;

    private final OutboxEventService outboxEventService;

    public void login(LoginDto loginDto) {
        if (loginDto == null) {
            throw new CodeSageRuntimeException("LoginDto doesn't have value. Object is null");
        }
        loginDto.setUsername(loginDto.getUsername().trim());
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException ex) {
            throw new CodeSageRuntimeException("Niewłaściwe hasło lub login");
        }
    }

    @Transactional
    public void registerDetails(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new CodeSageRuntimeException("RegisterDto doesn't have value. Object is null");
        }
        if (!registerDto.getPassword().equals(registerDto.getRepeatedPassword())) {
            throw new CodeSageRuntimeException("Password confirmation does not match the original password");
        }
        registerDto.setUsername(registerDto.getUsername().trim());
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new CodeSageRuntimeException("Taki login już istnieje!");
        }
        userRepository.save(hashingPassword(registerDto));
        firstCourseCreator.createFirstCourse(registerDto.getUsername());
        outboxEventService.createOutboxEvent(registerDto.getUsername());
    }

    private User hashingPassword(RegisterDto registerDto) {
        User user = userMapper.mapToUser(registerDto, Role.USER);
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return user;
    }

    public UsernameDto getUsername() {
        return new UsernameDto(authService.getLoggedUser().getUsername());
    }

    @Transactional
    public void createRandomUser() {
        RegisterDto randomUser = new RegisterDto();
        boolean checkUser = true;
        while (checkUser) {
            int number = random.nextInt(Integer.MAX_VALUE);
            randomUser.setUsername("User-" + number);
            randomUser.setPassword("User" + number + ".");
            checkUser = userRepository.existsByUsername(randomUser.getUsername());
        }
        userRepository.save(hashingPassword(randomUser));
        firstCourseCreator.createFirstCourse(randomUser.getUsername());
        login(LoginDto.builder().username(randomUser.getUsername()).password(randomUser.getPassword()).build());
    }

    @Transactional
    public void loginByExternalApi(String email) {
        if(email == null) {
            throw new CodeSageRuntimeException("Email is null");
        }
        if (!userRepository.existsByUsername(email)) {
            User user = User.builder().username(email).role(Role.USER).build();
            userRepository.save(user);
            firstCourseCreator.createFirstCourse(user.getUsername());
            outboxEventService.createOutboxEvent(user.getUsername());
        }
    }

}
