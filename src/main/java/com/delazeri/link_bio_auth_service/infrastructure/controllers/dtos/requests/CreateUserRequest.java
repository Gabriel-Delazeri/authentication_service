package com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
        @NotEmpty(message = "The first name field is required")
        @JsonProperty(value = "first_name")
        private String firstName;

        @NotEmpty(message = "The last name field is required")
        @JsonProperty(value = "last_name")
        private String lastName;

        @Email(message = "The email is not valid")
        @NotNull
        private String email;

        @Email(message = "The email confirmation is not valid")
        @NotNull
        @JsonProperty(value = "email_confirmation")
        private String emailConfirmation;

        @NotEmpty(message = "The username is required")
        private String username;

        @NotEmpty(message = "The password is required")
        private String password;

        @NotEmpty(message = "The password confirmation is required")
        @JsonProperty(value = "password_confirmation")
        private String passwordConfirmation;

        @AssertTrue(message = "The provided emails doesn't match")
        private boolean isEmailMatching() {
                assert this.email != null;
                return this.email.equals(emailConfirmation);
        }

        @AssertTrue(message = "The provided password doesn't match")
        private boolean isPasswordMatching() {
                 assert this.password != null;
                 return this.password.equals(passwordConfirmation);
        }
}
