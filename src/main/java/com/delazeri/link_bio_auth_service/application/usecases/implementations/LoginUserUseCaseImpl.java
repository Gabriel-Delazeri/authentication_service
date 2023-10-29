package com.delazeri.link_bio_auth_service.application.usecases.implementations;

import com.delazeri.link_bio_auth_service.application.gateways.AuthGateway;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.LoginUserUseCase;
import com.delazeri.link_bio_auth_service.domain.entity.User;

public class LoginUserUseCaseImpl implements LoginUserUseCase {
    private final AuthGateway authGateway;

    public LoginUserUseCaseImpl(AuthGateway authGateway) {
        this.authGateway = authGateway;
    }

    @Override
    public String loginUser(User user) {
        return authGateway.loginUser(user);
    }
}
