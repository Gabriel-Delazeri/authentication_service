package com.delazeri.link_bio_auth_service.infrastructure.services;

import com.delazeri.link_bio_auth_service.application.gateways.AuthGateway;
import com.delazeri.link_bio_auth_service.infrastructure.config.security.JwtService;
import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthService implements AuthGateway {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public String loginUser(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                username,
                password
        );

        Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return jwtService.generateToken((UserEntity) auth.getPrincipal());
    }
}
