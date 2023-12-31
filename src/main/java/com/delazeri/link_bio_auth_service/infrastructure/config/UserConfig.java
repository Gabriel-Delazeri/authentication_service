package com.delazeri.link_bio_auth_service.infrastructure.config;

import com.delazeri.link_bio_auth_service.application.gateways.AuthGateway;
import com.delazeri.link_bio_auth_service.application.gateways.UserGateway;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.CreateUserUseCase;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.LoginUserUseCase;
import com.delazeri.link_bio_auth_service.application.usecases.implementations.CreateUserUseCaseImpl;
import com.delazeri.link_bio_auth_service.application.usecases.implementations.LoginUserUseCaseImpl;
import com.delazeri.link_bio_auth_service.infrastructure.config.security.JwtService;
import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.repositories.UserRepository;
import com.delazeri.link_bio_auth_service.infrastructure.services.AuthService;
import com.delazeri.link_bio_auth_service.infrastructure.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class UserConfig {

    @Bean
    UserGateway<UUID> userGateway(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserService(userRepository, passwordEncoder);
    }

    @Bean
    CreateUserUseCase createUserUseCase(UserGateway<UUID> userGateway) {
        return new CreateUserUseCaseImpl<>(userGateway);
    }

    @Bean
    AuthGateway authGateway(
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        return new AuthService(authenticationManager, jwtService);
    }

    @Bean
    LoginUserUseCase loginUserUseCase(AuthGateway authGateway) {
        return new LoginUserUseCaseImpl(authGateway);
    }
}
