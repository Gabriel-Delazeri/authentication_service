package com.delazeri.link_bio_auth_service.application.usecases.implementations;

import com.delazeri.link_bio_auth_service.application.gateways.UserGateway;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.CreateUserUseCase;
import com.delazeri.link_bio_auth_service.domain.entity.User;

public class CreateUserUseCaseImpl<T> implements CreateUserUseCase {
    private final UserGateway<T> userGateway;

    public CreateUserUseCaseImpl(UserGateway<T> userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
