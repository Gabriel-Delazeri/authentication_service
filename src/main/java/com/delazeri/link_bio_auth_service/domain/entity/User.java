package com.delazeri.link_bio_auth_service.domain.entity;

import com.delazeri.link_bio_auth_service.domain.enums.AccountStatus;

import java.util.ArrayList;

public record User(
    String firstName,
    String lastName,
    String email,
    String username,
    String password,
    String imageUrl,
    ArrayList<Role> roles,
    AccountStatus accountStatus
) {
}
