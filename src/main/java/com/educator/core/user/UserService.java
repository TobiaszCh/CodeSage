package com.educator.core.user;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.dto.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerDetails(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new CodeSageRuntimeException("Obiekt jest nulem");
        }

        if(!registerDto.getPassword().equals(registerDto.getRepeatedPassword())) {
            throw new CodeSageRuntimeException("Powtórzenie hasła nie jest zgodne z oryginałem");
        }

        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new CodeSageRuntimeException("Taki login już istnieje!");
        }
        userRepository.save(hashingPassword(registerDto));
    }

    private User hashingPassword(RegisterDto registerDto) {
        User user = userMapper.mapToUser(registerDto);
        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setUsername(registerDto.getUsername().trim());
        return user;
    }
}
