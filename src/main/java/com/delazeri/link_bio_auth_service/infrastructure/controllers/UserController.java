package com.delazeri.link_bio_auth_service.infrastructure.controllers;

import com.delazeri.link_bio_auth_service.application.usecases.contracts.CreateUserUseCase;
import com.delazeri.link_bio_auth_service.domain.entity.User;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.requests.CreateUserRequest;
import com.delazeri.link_bio_auth_service.infrastructure.utils.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User user = userMapper.createUserRequestToDomainObj(createUserRequest);

        return ResponseEntity.ok(createUserUseCase.createUser(user));
    }
}
