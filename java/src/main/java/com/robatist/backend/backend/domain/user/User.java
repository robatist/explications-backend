package com.robatist.backend.backend.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"Person\"")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "\"userType\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "\"firstName\"")
    private String firstName;

    @Column(name = "\"lastName\"")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "nif")
    private String nif;

    @Column(name = "photo")
    private String photo;

    @Column(name = "active")
    private boolean active;

    public User() {
    }

    public User(String firstName, String lastName, int age, String nif, String photo, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nif = nif;
        this.photo = photo;
        this.active = active;
    }

    public User(int id, String firstName, String lastName, int age, String nif, String photo, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nif = nif;
        this.photo = photo;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && active == user.active && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(nif, user.nif) && Objects.equals(photo, user.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, nif, photo, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nif='" + nif + '\'' +
                ", photo='" + photo + '\'' +
                ", active=" + active +
                '}';
    }

    // Build Design Pattern
    public static class UserBuilder {
        /**
         * The object to build
         */
        private final User toBuild;

        // Constructor to create a new User
        public UserBuilder() {
            toBuild = new User();
        }

        // Constructor to update an existing user
        public UserBuilder(User user) {
            toBuild = user;
        }

        public User build() {
            return toBuild;
        }

        public UserBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public UserBuilder firstName(String firstName) {
            toBuild.setFirstName(firstName);

            return this;
        }

        public UserBuilder lastName(String lastName) {
            toBuild.setLastName(lastName);

            return this;
        }

        public UserBuilder age(int age) {
            toBuild.setAge(age);

            return this;
        }

        public UserBuilder nif(String nif) {
            toBuild.setNif(nif);

            return this;
        }

        public UserBuilder photo(String photo) {
            toBuild.setPhoto(photo);

            return this;
        }

        public UserBuilder active(boolean active) {
            toBuild.setActive(active);

            return this;
        }
    }
}
