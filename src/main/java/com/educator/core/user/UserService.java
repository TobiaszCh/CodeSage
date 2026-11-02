package com.educator.core.user;

import com.educator.auth.AuthService;
import com.educator.core.course.FirstCourseCreator;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import com.educator.core.outbox_event.OutboxEventService;
import com.educator.core.outbox_event.OutboxEventType;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import com.educator.core.user.dto.UserInfoDto;
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
    private final Random random = new Random();
    private final FirstCourseCreator firstCourseCreator;
    private final OutboxEventService outboxEventService;
    private final AuthService authService;

    public void login(LoginDto loginDto) {
        if (loginDto == null) {
            throw new CodeSageRuntimeException("LoginDto is null");
        }
        loginDto.setUsername(loginDto.getUsername().trim());
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getUsername(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException ex) {
            throw CodeSageUserException.withUserMessage("Niewłaściwe hasło lub login");
        }
    }

    @Transactional
    public void registerDetails(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new CodeSageRuntimeException("RegisterDto is null");
        }
        if (!registerDto.getPassword().equals(registerDto.getRepeatedPassword())) {
            throw new CodeSageRuntimeException("Password confirmation does not match the original password");
        }
        registerDto.setUsername(registerDto.getUsername().trim());
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw CodeSageUserException.withUserMessage("Taki login już istnieje!");
        }
        User user = userMapper.mapToUser(registerDto, Role.USER);
        user.setPassword(hashingPassword(user.getPassword()));
        userRepository.save(user);
        firstCourseCreator.createFirstCourse(registerDto.getUsername());
        outboxEventService.createOutboxEvent(registerDto.getUsername(), OutboxEventType.EMAIL);
    }

    private String hashingPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public UserInfoDto getLoggedUserInfo() {
        User loggedUser = authService.getLoggedUser();
        return userMapper.mapToUserInfoDto(loggedUser);
    }

    @Transactional
    public void createRandomUser() {
        RegisterDto randomUser = new RegisterDto();
        boolean checkUser = true;
        while (checkUser) {
            int numberToUser = random.nextInt(Integer.MAX_VALUE);
            int numberToPassword = random.nextInt(Integer.MAX_VALUE);
            randomUser.setUsername("User-" + numberToUser + "@random.com");
            randomUser.setPassword("User" + numberToPassword + ".");
            checkUser = userRepository.existsByUsername(randomUser.getUsername());
        }
        User user = userMapper.mapToUser(randomUser, Role.DEMO);
        user.setPassword(hashingPassword(user.getPassword()));
        userRepository.save(user);
        firstCourseCreator.createFirstCourse(randomUser.getUsername());
        login(LoginDto.builder().username(randomUser.getUsername()).password(randomUser.getPassword()).build());
    }

    @Transactional
    public void loginByExternalApi(String email) {
        if (email == null) {
            throw new CodeSageRuntimeException("Email is null");
        }
        if (!userRepository.existsByUsername(email)) {
            User user = User.builder().username(email).role(Role.USER).build();
            userRepository.save(user);
            firstCourseCreator.createFirstCourse(user.getUsername());
            outboxEventService.createOutboxEvent(user.getUsername(), OutboxEventType.EMAIL);
        }
    }

}
