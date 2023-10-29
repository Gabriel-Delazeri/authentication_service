package com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.repositories;

import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findByUsername(String username);
}
