package com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterUserResponse(
        @JsonProperty(value = "first_name")
        String firstName,
        @JsonProperty(value = "last_name")
        String lastName,
        String username,
        String email
) {
}
