package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "login")
@Entity
public class Login extends AbstractEntity<String>{
    @Id
    @GenericGenerator(name="id_login",strategy = "uuid2")
    @GeneratedValue(generator = "id_login",strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    private String password;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @OneToOne
    @JoinColumn(name = "id_role")
    private Role role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
//    public Role getRole() {
//        return role;
//    }

//    public void setRole(Integer role) {
//        this.role = role;
//    }
}
