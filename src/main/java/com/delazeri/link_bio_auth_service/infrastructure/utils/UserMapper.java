package com.delazeri.link_bio_auth_service.infrastructure.utils;

import com.delazeri.link_bio_auth_service.domain.entity.User;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.requests.CreateUserRequest;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User createUserRequestToDomainObj(CreateUserRequest createUserRequest) {
        User user = new User();

        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(createUserRequest.getPassword());
        user.setImageUrl("");

        return user;
    }
}
