package com.enigma.reimbursment.online.models.request.register;

import com.enigma.reimbursment.online.entities.Role;

public class RegisterRequest {
    private String Username;
    private String password;
    private Role role;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "Username='" + Username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
