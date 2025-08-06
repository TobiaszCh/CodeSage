package com.educator.core.user;

import com.educator.core.email.EmailService;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.dto.LoginDto;
import com.educator.core.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;
    public final AuthenticationManager manager;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final EmailService emailService;

    public Authentication authenticate(LoginDto loginDto) {
        if (loginDto == null) {
            throw new CodeSageRuntimeException("LoginDto doesn't have value. Object is null");
        }
        try {
            return manager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername()
                    , loginDto.getPassword()));
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
        emailService.sendWelcomeMessage(registerDto.getUsername());
    }

    private User hashingPassword(RegisterDto registerDto) {
        User user = userMapper.mapToUser(registerDto);
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setUsername(registerDto.getUsername().trim());
        return user;
    }

}
