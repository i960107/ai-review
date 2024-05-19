package com.aireview.review.login.usernamepassword;

import com.aireview.review.authentication.jwt.JwtService;
import com.aireview.review.domain.user.User;
import com.aireview.review.login.CustomUserDetails;
import com.aireview.review.login.LoginSuccessHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationSuccessHandler extends LoginSuccessHandler {
    public UsernamePasswordAuthenticationSuccessHandler(JwtService jwtService, ObjectMapper objectMapper) {
        super(jwtService, objectMapper);
    }

    @Override
    protected User processAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }
}
