package com.educator.auth;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.User;
import com.educator.core.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${app.redirected.url}")
    private String redirectedUrl;

    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Object userObject = authentication.getPrincipal();
        if (userObject instanceof OAuth2User) {
            String email = ((OAuth2User) userObject).getAttribute("email");
            if(email == null) throw new CodeSageRuntimeException("Email is null");
            if (!userRepository.existsByUsername(email)) {
                User user = User.builder().username(email).build();
                userRepository.save(user);
            }
        }
        response.sendRedirect(redirectedUrl);
    }
}
