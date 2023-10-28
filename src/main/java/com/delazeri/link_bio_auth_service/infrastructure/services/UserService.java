package com.delazeri.link_bio_auth_service.infrastructure.services;

import com.delazeri.link_bio_auth_service.application.gateways.UserGateway;
import com.delazeri.link_bio_auth_service.domain.entity.User;
import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.entities.UserEntity;
import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserGateway<UUID> {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        User userDomainObj = new User();
        BeanUtils.copyProperties(repository.save(userEntity), userDomainObj);

        return userDomainObj;
    }
}
