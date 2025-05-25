package com.educator.core.user;

import com.educator.core.exception.CodeSageRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    public final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
    
    public void registerDetails(RegisterDto registerDto) {
        if (registerDto == null) {
            throw new CodeSageRuntimeException("Obiekt jest nullem");
        }
        if(!registerDto.getPassword().equals(registerDto.getRepeatPassword())) {
            throw new CodeSageRuntimeException("Powtórzenie hasła nie jest zgodne z hasłem");
        }
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new CodeSageRuntimeException("Taki login już istnieje!");
        }
        userRepository.save(userMapper.mapToUser(registerDto));
    }
}
