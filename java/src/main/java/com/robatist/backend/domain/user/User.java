package com.robatist.backend.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.robatist.backend.token.Token;
import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "\"Person\"")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "\"userType\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "\"firstName\"")
    private String firstName;

    @Column(name = "\"lastName\"")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "nif")
    private String nif;

    @Column(name = "photo")
    private String photo;

    @Column(name = "active")
    private boolean active;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, int age, String nif, String photo, boolean active, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.nif = nif;
        this.photo = photo;
        this.active = active;
        this.role = role;
    }

    public User(int id, String firstName, String lastName, String email, String password, int age, String nif, String photo, boolean active, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.nif = nif;
        this.photo = photo;
        this.active = active;
        this.role = role;
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

    public String getFullname() {
        return firstName + " " + lastName;
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

    public Role getRole() {
        return role;
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

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && active == user.active && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(nif, user.nif) && Objects.equals(photo, user.photo) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, age, nif, photo, active, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nif='" + nif + '\'' +
                ", photo='" + photo + '\'' +
                ", active=" + active +
                ", role=" + role +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Build Design Pattern
    // TODO: 21/04/2024 SUBSTITUIR PELA ANOTAÇÃO @Builder
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

        public UserBuilder email(String email) {
            toBuild.setEmail(email);

            return this;
        }

        public UserBuilder password(String password) {
            toBuild.setPassword(password);

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

        public UserBuilder role(Role role) {
            toBuild.setRole(role);

            return this;
        }
    }
}
