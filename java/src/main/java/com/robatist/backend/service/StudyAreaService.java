package com.robatist.backend.service;

import com.robatist.backend.domain.StudyArea;
import com.robatist.backend.exception.StudyAreaNotFoundException;
import com.robatist.backend.exception.StudyAreasNotFoundException;
import com.robatist.backend.logging.Logger;
import com.robatist.backend.logging.enumeration.LogTag;
import com.robatist.backend.repository.StudyAreaRepository;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudyAreaService {

    private static final Logger LOGGER = new Logger(StudyAreaService.class);
    private final StudyAreaRepository studyAreaRepository;

    @Autowired
    public StudyAreaService(final StudyAreaRepository studyAreaRepository) {
        this.studyAreaRepository = studyAreaRepository;
    }

    public List<StudyArea> getAllStudyAreas() {
        final List<StudyArea> studyAreaList = studyAreaRepository.findAll();

        if (studyAreaList.isEmpty()) {
            throw new StudyAreasNotFoundException();
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.STUDY_AREAS, LogTag.RETRIEVED),
                "All Study Areas Retrieved.");

        return studyAreaList;
    }

    public StudyArea getStudyAreaById(int id) {
        final Optional<StudyArea> studyAreaOptional = studyAreaRepository.findById(id);

        if (studyAreaOptional.isEmpty()) {
            throw new StudyAreaNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.STUDY_AREAS, LogTag.RETRIEVED),
                MessageFormat.format("Study Area {0} Retrieved.", id));

        return studyAreaOptional.get();
    }

    public StudyArea createStudyArea(StudyArea studyArea) {

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.STUDY_AREAS, LogTag.CREATED), "Study Area Created.");

        return studyAreaRepository.save(studyArea);
    }

    public StudyArea updateStudyArea(int id, StudyArea studyArea) {
        final Optional<StudyArea> studyAreaOptional = studyAreaRepository.findById(id);

        if (studyAreaOptional.isEmpty()) {
            throw new StudyAreaNotFoundException(id);
        }

        StudyArea studyAreaUpdated = studyAreaOptional.get();

        studyAreaUpdated = new StudyArea.StudyAreaBuilder(studyAreaUpdated) //
                .designation(studyArea.getDesignation()) //
                .description(studyArea.getDescription()) //
                .build();

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.STUDY_AREAS, LogTag.UPDATED), MessageFormat.format("Study Area {0} Updated.", id));

        return studyAreaRepository.save(studyAreaUpdated);
    }

    public void deleteStudyArea(int id) {
        final Optional<StudyArea> studyAreaOptional = studyAreaRepository.findById(id);

        if (studyAreaOptional.isEmpty()) {
            throw new StudyAreaNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.STUDY_AREAS, LogTag.DELETED), MessageFormat.format("Study Area {0} deleted.", id));

        studyAreaRepository.deleteById(id);
    }

}
