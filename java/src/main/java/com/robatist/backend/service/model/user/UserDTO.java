package com.robatist.backend.service.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserDTO {

    // TODO: 21/10/2023 IMPLEMENTAR AS DUAS SUBCLASSES DE USER (TEACHER AND STUDENT)

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int id;

    @JsonProperty("firstName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonProperty("lastName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonProperty("password")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @JsonProperty("age")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int age;

    @JsonProperty("nif")
    private String nif;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean active;

    @JsonProperty("role")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String role;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String email, String password, int age, String nif, String photo, boolean active, String role) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && age == userDTO.age && active == userDTO.active && Objects.equals(firstName, userDTO.firstName) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && Objects.equals(nif, userDTO.nif) && Objects.equals(photo, userDTO.photo) && Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, age, nif, photo, active, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nif='" + nif + '\'' +
                ", photo='" + photo + '\'' +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }

    // Build Design Pattern
    public static class UserDTOBuilder {
        /**
         * The object to build
         */
        private final UserDTO toBuild;

        // Constructor to create a new User
        public UserDTOBuilder() {
            toBuild = new UserDTO();
        }

        // Constructor to update an existing user
        public UserDTOBuilder(UserDTO user) {
            toBuild = user;
        }

        public UserDTO build() {
            return toBuild;
        }

        public UserDTOBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public UserDTOBuilder firstName(String firstName) {
            toBuild.setFirstName(firstName);

            return this;
        }

        public UserDTOBuilder lastName(String lastName) {
            toBuild.setLastName(lastName);

            return this;
        }

        public UserDTOBuilder email(String email) {
            toBuild.setEmail(email);

            return this;
        }

        public UserDTOBuilder password(String password) {
            toBuild.setPassword(password);

            return this;
        }

        public UserDTOBuilder age(int age) {
            toBuild.setAge(age);

            return this;
        }

        public UserDTOBuilder nif(String nif) {
            toBuild.setNif(nif);

            return this;
        }

        public UserDTOBuilder photo(String photo) {
            toBuild.setPhoto(photo);

            return this;
        }

        public UserDTOBuilder active(boolean active) {
            toBuild.setActive(active);

            return this;
        }

        public UserDTOBuilder role(String role) {
            toBuild.setRole(role);

            return this;
        }
    }
}
