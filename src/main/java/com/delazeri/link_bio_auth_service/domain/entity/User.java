package com.delazeri.link_bio_auth_service.domain.entity;

import com.delazeri.link_bio_auth_service.domain.enums.AccountStatus;

import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String imageUrl;
    private ArrayList<Role> roles;
    private AccountStatus accountStatus;

    public User(){}

    public User(String firstName, String lastName, String email, String username, String password, String imageUrl, ArrayList<Role> roles, AccountStatus accountStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.imageUrl = imageUrl;
        this.roles = roles;
        this.accountStatus = accountStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
