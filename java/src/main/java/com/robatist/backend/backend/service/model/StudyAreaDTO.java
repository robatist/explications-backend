package com.robatist.backend.backend.service.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StudyAreaDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int id;

    @JsonProperty("designation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String designation;

    @JsonProperty("description")
    private String description;

    public StudyAreaDTO() {
    }

    public StudyAreaDTO(int id, String designation, String description) {
        this.id = id;
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
        StudyAreaDTO that = (StudyAreaDTO) o;
        return id == that.id && Objects.equals(designation, that.designation) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description);
    }

    @Override
    public String toString() {
        return "StudyAreaDTO{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // Build Design Pattern
    public static class StudyAreaDTOBuilder {
        /**
         * The object to build
         */
        private final StudyAreaDTO toBuild;

        public StudyAreaDTOBuilder() {
            toBuild = new StudyAreaDTO();
        }

        public StudyAreaDTOBuilder(StudyAreaDTO studyArea) {
            toBuild = studyArea;
        }

        public StudyAreaDTO build() {
            return toBuild;
        }

        public StudyAreaDTOBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public StudyAreaDTOBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public StudyAreaDTOBuilder description(String description) {
            toBuild.setDescription(description);

            return this;
        }
    }

}
