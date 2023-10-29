package com.delazeri.link_bio_auth_service.infrastructure.controllers;

import com.delazeri.link_bio_auth_service.application.usecases.contracts.CreateUserUseCase;
import com.delazeri.link_bio_auth_service.application.usecases.contracts.LoginUserUseCase;
import com.delazeri.link_bio_auth_service.domain.entity.User;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.requests.CreateUserRequest;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.requests.LoginUserRequest;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses.LoginUserResponse;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses.RegisterUserResponse;
import com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses.Response;
import com.delazeri.link_bio_auth_service.infrastructure.utils.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final UserMapper userMapper;

    public AuthController(CreateUserUseCase createUserUseCase, LoginUserUseCase loginUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "register")
    public ResponseEntity<Response<RegisterUserResponse>> registerUser(
            @RequestBody @Valid CreateUserRequest createUserRequest
    ) {
        User user = createUserUseCase.createUser(
                userMapper.createUserRequestToDomainObj(createUserRequest)
        );

        return ResponseEntity.ok(
                new Response<>(new RegisterUserResponse(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUsername(),
                        user.getEmail()
                ), true, new ArrayList<>())
        );
    }

    @PostMapping(value = "login")
    public ResponseEntity<Response<LoginUserResponse>> login(@RequestBody LoginUserRequest loginRequest) {
        String token = this.loginUserUseCase.loginUser(loginRequest.username(), loginRequest.password());

        return ResponseEntity.ok(
                new Response<>(new LoginUserResponse(token), true, new ArrayList<>())
        );
    }
}
