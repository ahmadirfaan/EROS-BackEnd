package com.enigma.reimbursment.online.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "role")
@Entity
public class Role extends AbstractEntity <String>{

    @Id
    @GenericGenerator(name="id_role",strategy = "uuid2")
    @GeneratedValue(generator = "id_role",strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "role_name")
    private String roleName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
