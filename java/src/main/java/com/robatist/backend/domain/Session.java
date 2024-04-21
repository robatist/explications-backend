package com.robatist.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.robatist.backend.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "\"Session\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "\"sessionDate\"")
    private LocalDateTime sessionDate;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "explication_id", referencedColumnName = "id")
    private Explication explication;

    public Session() {
    }

    public Session(String designation, LocalDateTime sessionDate, User student, Explication explication) {
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

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Explication getExplication() {
        return explication;
    }

    public void setExplication(Explication explication) {
        this.explication = explication;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", designação='" + designation + '\'' +
                ", sessionDate=" + sessionDate +
                ", student=" + student +
                ", explication=" + explication +
                '}';
    }

    // Build Design Pattern
    public static class SessionBuilder {
        /**
         * The object to build
         */
        private final Session toBuild;

        public SessionBuilder() {
            toBuild = new Session();
        }

        public SessionBuilder(Session session) {
            toBuild = session;
        }

        public Session build() {
            return toBuild;
        }

        public SessionBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public SessionBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public SessionBuilder sessionDate(LocalDateTime sessionDate) {
            toBuild.setSessionDate(sessionDate);

            return this;
        }

        public SessionBuilder student(User user) {
            toBuild.setStudent(user);

            return this;
        }

        public SessionBuilder explication(Explication explication) {
            toBuild.setExplication(explication);

            return this;
        }
    }
}
