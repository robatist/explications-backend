package com.robatist.backend.backend.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.robatist.backend.backend.service.model.user.UserDTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int id;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("sessionDate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime sessionDate;

    @JsonProperty("student")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDTO student;

    @JsonProperty("explication")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ExplicationDTO explication;

    public SessionDTO() {
    }

    public SessionDTO(int id, String designation, LocalDateTime sessionDate, UserDTO student, ExplicationDTO explication) {
        this.id = id;
        this.designation = designation;
        this.sessionDate = sessionDate;
        this.student = student;
        this.explication = explication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public UserDTO getStudent() {
        return student;
    }

    public void setStudent(UserDTO student) {
        this.student = student;
    }

    public ExplicationDTO getExplication() {
        return explication;
    }

    public void setExplication(ExplicationDTO explication) {
        this.explication = explication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionDTO that = (SessionDTO) o;
        return id == that.id && Objects.equals(designation, that.designation) && Objects.equals(sessionDate, that.sessionDate) && Objects.equals(student, that.student) && Objects.equals(explication, that.explication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, sessionDate, student, explication);
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", sessionDate=" + sessionDate +
                ", student=" + student +
                ", explication=" + explication +
                '}';
    }

    // Build Design Pattern
    public static class SessionDTOBuilder {
        /**
         * The object to build
         */
        private final SessionDTO toBuild;

        public SessionDTOBuilder() {
            toBuild = new SessionDTO();
        }

        public SessionDTOBuilder(SessionDTO session) {
            toBuild = session;
        }

        public SessionDTO build() {
            return toBuild;
        }

        public SessionDTOBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public SessionDTOBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public SessionDTOBuilder sessionDate(LocalDateTime sessionDate) {
            toBuild.setSessionDate(sessionDate);

            return this;
        }

        public SessionDTOBuilder student(UserDTO user) {
            toBuild.setStudent(user);

            return this;
        }

        public SessionDTOBuilder explication(ExplicationDTO explication) {
            toBuild.setExplication(explication);

            return this;
        }
    }

}
