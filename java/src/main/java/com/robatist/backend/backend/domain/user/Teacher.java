package com.robatist.backend.backend.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends User {
    public Teacher() {
        super();
    }

    public Teacher(String firstName, String lastName, int age, String nif, String photo, boolean active) {
        super(firstName, lastName, age, nif, photo, active);
    }

    public Teacher(int id, String firstName, String lastName, int age, String nif, String photo, boolean active) {
        super(id, firstName, lastName, age, nif, photo, active);
    }
}
