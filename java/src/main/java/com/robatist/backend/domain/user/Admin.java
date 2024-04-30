package com.robatist.backend.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {
    public Admin() {
        super();
    }

    public Admin(String firstName, String lastName, String email, String password, int age, String nif, String photo, boolean active, Role role) {
        super(firstName, lastName, email, password, age, nif, photo, active, role);
    }

    public Admin(int id, String firstName, String lastName, String email, String password, int age, String nif, String photo, boolean active, Role role) {
        super(id, firstName, lastName, email, password, age, nif, photo, active, role);
    }
}
