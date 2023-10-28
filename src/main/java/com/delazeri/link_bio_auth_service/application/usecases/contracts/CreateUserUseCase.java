package com.delazeri.link_bio_auth_service.application.usecases.contracts;

import com.delazeri.link_bio_auth_service.domain.entity.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
