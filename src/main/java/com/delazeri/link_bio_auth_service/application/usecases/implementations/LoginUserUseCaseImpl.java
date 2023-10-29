package com.delazeri.link_bio_auth_service.application.usecases.implementations;

import com.delazeri.link_bio_auth_service.application.gateways.AuthGateway;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.LoginUserUseCase;

public class LoginUserUseCaseImpl implements LoginUserUseCase {
    private final AuthGateway authGateway;

    public LoginUserUseCaseImpl(AuthGateway authGateway) {
        this.authGateway = authGateway;
    }

    @Override
    public String loginUser(String username, String password) {
        return authGateway.loginUser(username, password);
    }
}
