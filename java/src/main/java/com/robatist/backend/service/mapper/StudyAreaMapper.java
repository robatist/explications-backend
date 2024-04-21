package com.robatist.backend.service.mapper;

import com.robatist.backend.domain.StudyArea;
import com.robatist.backend.service.model.StudyAreaDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudyAreaMapper {

    /**
     * Method to map a list of StudyAreas {@link StudyArea} to a list of StudyAreasDTO {@link StudyAreaDTO}
     *
     * @param studyAreaList the data source
     * @return the one list {@link List} of StudyAreasDTO {@link StudyAreaDTO}
     */
    public List<StudyAreaDTO> mapStudyAreaListToStudyAreaDTOList(final List<StudyArea> studyAreaList) {
        return Objects.nonNull(studyAreaList) ?
                studyAreaList.stream().map(this::mapStudyAreaToStudyAreaDTO).collect(Collectors.toList())
                : null;
    }

    /**
     * Method to map a StudyArea {@link StudyArea} to a StudyAreaDTO {@link StudyAreaDTO}
     *
     * @param studyArea the data source
     * @return the one StudyAreaDTO object {@link StudyAreaDTO}
     */
    public StudyAreaDTO mapStudyAreaToStudyAreaDTO(final StudyArea studyArea) {
        return Objects.nonNull(studyArea) ?
                new StudyAreaDTO.StudyAreaDTOBuilder()
                        .id(studyArea.getId())
                        .designation(studyArea.getDesignation())
                        .description(studyArea.getDescription())
                        .build()
                : null;
    }

    /**
     * Method to map a StudyAreaDTO {@link StudyAreaDTO} to a StudyArea {@link StudyArea}
     *
     * @param studyAreaDTO the data source
     * @return the one StudyArea object {@link StudyArea}
     */
    public StudyArea mapStudyAreaDTOToStudyArea(final StudyAreaDTO studyAreaDTO) {
        return Objects.nonNull(studyAreaDTO) ?
                new StudyArea.StudyAreaBuilder()
                        .id(studyAreaDTO.getId())
                        .designation(studyAreaDTO.getDesignation())
                        .description(studyAreaDTO.getDescription())
                        .build()
                : null;
    }

}
