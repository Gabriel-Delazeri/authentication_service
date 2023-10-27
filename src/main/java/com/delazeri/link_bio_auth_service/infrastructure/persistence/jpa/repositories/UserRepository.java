package com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.repositories;

import com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
