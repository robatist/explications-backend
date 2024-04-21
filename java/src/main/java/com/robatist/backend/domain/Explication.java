package com.robatist.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.robatist.backend.domain.user.User;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"Explication\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Explication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "\"studyArea_id\"", referencedColumnName = "id")
    private StudyArea studyArea;

    @Column(name = "\"isRemote\"")
    private boolean isRemote;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private User teacher;

    @Column(name = "active")
    private boolean active;

    public Explication() {
    }

    public Explication(String designation, String description, StudyArea studyArea, boolean isRemote, User teacher, boolean active) {
        this.designation = designation;
        this.description = description;
        this.studyArea = studyArea;
        this.isRemote = isRemote;
        this.teacher = teacher;
        this.active = active;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StudyArea getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(StudyArea studyArea) {
        this.studyArea = studyArea;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
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
        Explication that = (Explication) o;
        return id == that.id && isRemote == that.isRemote && active == that.active && Objects.equals(designation, that.designation) && Objects.equals(description, that.description) && Objects.equals(studyArea, that.studyArea) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public String toString() {
        return "Explication{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                ", studyArea=" + studyArea +
                ", isRemote=" + isRemote +
                ", teacher=" + teacher +
                ", active=" + active +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, studyArea, isRemote, teacher, active);
    }

    // Build Design Pattern
    public static class ExplicationBuilder {
        /**
         * The object to build
         */
        private final Explication toBuild;

        public ExplicationBuilder() {
            toBuild = new Explication();
        }

        public ExplicationBuilder(Explication explication) {
            toBuild = explication;
        }

        public Explication build() {
            return toBuild;
        }

        public ExplicationBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public ExplicationBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public ExplicationBuilder description(String description) {
            toBuild.setDescription(description);

            return this;
        }

        public ExplicationBuilder studyArea(StudyArea studyArea) {
            toBuild.setStudyArea(studyArea);

            return this;
        }

        public ExplicationBuilder isRemote(boolean isRemote) {
            toBuild.setRemote(isRemote);

            return this;
        }

        public ExplicationBuilder teacher(User user) {
            toBuild.setTeacher(user);

            return this;
        }

        public ExplicationBuilder active(boolean isActive) {
            toBuild.setActive(isActive);

            return this;
        }
    }
}
