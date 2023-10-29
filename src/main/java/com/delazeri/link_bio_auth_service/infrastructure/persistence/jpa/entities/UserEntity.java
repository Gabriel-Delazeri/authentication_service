package com.delazeri.link_bio_auth_service.infrastructure.persistence.jpa.entities;

import com.delazeri.link_bio_auth_service.domain.enums.AccountStatus;
import com.delazeri.link_bio_auth_service.domain.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    private String email;
    private String password;
    private AccountStatus accountStatus;
    private Role role;
}
