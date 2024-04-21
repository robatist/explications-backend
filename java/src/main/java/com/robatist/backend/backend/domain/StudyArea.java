package com.robatist.backend.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "\"StudyArea\"")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudyArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "designation")
    private String designation;

    @Column(name = "description")
    private String description;

    public StudyArea() {
    }

    public StudyArea(String designation, String description) {
        this.designation = designation;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyArea that = (StudyArea) o;
        return id == that.id && Objects.equals(designation, that.designation) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description);
    }

    @Override
    public String toString() {
        return "StudyArea{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // Build Design Pattern
    public static class StudyAreaBuilder {
        /**
         * The object to build
         */
        private final StudyArea toBuild;

        public StudyAreaBuilder() {
            toBuild = new StudyArea();
        }

        public StudyAreaBuilder(StudyArea studyArea) {
            toBuild = studyArea;
        }

        public StudyArea build() {
            return toBuild;
        }

        public StudyAreaBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public StudyAreaBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public StudyAreaBuilder description(String description) {
            toBuild.setDescription(description);

            return this;
        }
    }

}
