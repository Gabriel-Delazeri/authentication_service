package com.delazeri.link_bio_auth_service.infrastructure.config;

import com.delazeri.link_bio_auth_service.application.gateways.UserGateway;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.CreateUserUseCase;
import com.delazeri.link_bio_auth_service.application.usecases.implementations.CreateUserUseCaseImpl;
import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.repositories.UserRepository;
import com.delazeri.link_bio_auth_service.infrastructure.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
