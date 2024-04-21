package com.robatist.backend.backend.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.robatist.backend.backend.service.model.user.UserDTO;

import java.util.Objects;

public class ExplicationDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int id;

    @JsonProperty("designation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String designation;

    @JsonProperty("description")
    private String description;

    @JsonProperty("studyArea")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StudyAreaDTO studyArea;

    @JsonProperty("isRemote")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isRemote;

    @JsonProperty("teacher")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDTO teacher;

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean active;

    public ExplicationDTO() {
    }

    public ExplicationDTO(int id, String designation, String description, StudyAreaDTO studyArea, boolean isRemote, UserDTO teacher, boolean active) {
        this.id = id;
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

    public StudyAreaDTO getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(StudyAreaDTO studyArea) {
        this.studyArea = studyArea;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public UserDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(UserDTO teacher) {
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
        ExplicationDTO that = (ExplicationDTO) o;
        return id == that.id && isRemote == that.isRemote && active == that.active && Objects.equals(designation, that.designation) && Objects.equals(description, that.description) && Objects.equals(studyArea, that.studyArea) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, designation, description, studyArea, isRemote, teacher, active);
    }

    @Override
    public String toString() {
        return "ExplicationDTO{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                ", studyArea=" + studyArea +
                ", isRemote=" + isRemote +
                ", teacher=" + teacher +
                ", active=" + active +
                '}';
    }

    // Build Design Pattern
    public static class ExplicationDTOBuilder {
        /**
         * The object to build
         */
        private final ExplicationDTO toBuild;

        public ExplicationDTOBuilder() {
            toBuild = new ExplicationDTO();
        }

        public ExplicationDTOBuilder(ExplicationDTO explication) {
            toBuild = explication;
        }

        public ExplicationDTO build() {
            return toBuild;
        }

        public ExplicationDTOBuilder id(int id) {
            toBuild.setId(id);

            return this;
        }

        public ExplicationDTOBuilder designation(String designation) {
            toBuild.setDesignation(designation);

            return this;
        }

        public ExplicationDTOBuilder description(String description) {
            toBuild.setDescription(description);

            return this;
        }

        public ExplicationDTOBuilder studyArea(StudyAreaDTO studyArea) {
            toBuild.setStudyArea(studyArea);

            return this;
        }

        public ExplicationDTOBuilder isRemote(boolean isRemote) {
            toBuild.setRemote(isRemote);

            return this;
        }

        public ExplicationDTOBuilder teacher(UserDTO user) {
            toBuild.setTeacher(user);

            return this;
        }

        public ExplicationDTOBuilder active(boolean isActive) {
            toBuild.setActive(isActive);

            return this;
        }
    }
}
