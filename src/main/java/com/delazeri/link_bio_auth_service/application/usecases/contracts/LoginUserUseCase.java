package com.delazeri.link_bio_auth_service.application.usecases.contracts;

public interface LoginUserUseCase {
    String loginUser(String username, String password);
}
