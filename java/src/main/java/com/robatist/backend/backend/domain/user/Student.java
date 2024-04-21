package com.robatist.backend.backend.domain.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends User {
    public Student() {
        super();
    }

    public Student(String firstName, String lastName, int age, String nif, String photo, boolean active) {
        super(firstName, lastName, age, nif, photo, active);
    }

    public Student(int id, String firstName, String lastName, int age, String nif, String photo, boolean active) {
        super(id, firstName, lastName, age, nif, photo, active);
    }
}
