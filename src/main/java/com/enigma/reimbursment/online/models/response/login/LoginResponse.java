package com.enigma.reimbursment.online.models.response.login;


import com.enigma.reimbursment.online.models.response.role.RoleResponse;

public class LoginResponse {

    private String id;
    private String email;
    //Pasword tidak diperlukan
    private RoleResponse role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
