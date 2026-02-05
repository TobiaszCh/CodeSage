package com.educator.core.user;

import com.educator.auth.AuthService;
import com.educator.core.course.FirstCourseCreator;
import com.educator.core.email.EmailService;
import com.educator.core.exception.CodeSageRuntimeException;
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

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthenticationManager manager;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final EmailService emailService;

    private final AuthService authService;

    private final Random random = new Random();

    private final FirstCourseCreator firstCourseCreator;

    public void login(LoginDto loginDto) {
        if (loginDto == null) {
            throw new CodeSageRuntimeException("LoginDto doesn't have value. Object is null");
        }
        try {
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername()
                    , loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException ex) {
            throw new CodeSageRuntimeException("Niewłaściwe hasło lub login");
        }
    }

    public void registerDetails(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new CodeSageRuntimeException("RegisterDto doesn't have value. Object is null");
        }
        if (!registerDto.getPassword().equals(registerDto.getRepeatedPassword())) {
            throw new CodeSageRuntimeException("Powtórzenie hasła nie jest zgodne z oryginałem");
        }
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new CodeSageRuntimeException("Taki login już istnieje!");
        }
        userRepository.save(hashingPassword(registerDto));
        firstCourseCreator.createFirstCourse(registerDto.getUsername());
        emailService.sendWelcomeMessage(registerDto.getUsername());
    }

    private User hashingPassword(RegisterDto registerDto) {
        User user = userMapper.mapToUser(registerDto);
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setUsername(registerDto.getUsername().trim());
        return user;
    }

    public UsernameDto getUsername() {
        return new UsernameDto(authService.getLoggedUser().getUsername());
    }

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

}
