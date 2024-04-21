package com.robatist.backend.backend.service;

import com.robatist.backend.backend.domain.Explication;
import com.robatist.backend.backend.exception.ExplicationNotFoundException;
import com.robatist.backend.backend.exception.ExplicationsNotFoundException;
import com.robatist.backend.backend.logging.Logger;
import com.robatist.backend.backend.logging.enumeration.LogTag;
import com.robatist.backend.backend.repository.ExplicationRepository;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExplicationService {

    private static final Logger LOGGER = new Logger(UserService.class);
    private final ExplicationRepository explicationRepository;

    @Autowired
    public ExplicationService(final ExplicationRepository explicationRepository) {
        this.explicationRepository = explicationRepository;
    }

    public List<Explication> getAllExplications() {
        final List<Explication> explicationList = explicationRepository.findAll();

        if (explicationList.isEmpty()) {
            throw new ExplicationsNotFoundException();
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.EXPLICATIONS, LogTag.RETRIEVED), "All Explications Retrieved.");

        return explicationList;
    }

    public Explication getExplicationById(int id) {
        final Optional<Explication> explicationOptional = explicationRepository.findById(id);

        if (explicationOptional.isEmpty()) {
            throw new ExplicationNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.EXPLICATIONS, LogTag.RETRIEVED),
                MessageFormat.format("Explication {0} Retrieved.", id));

        return explicationOptional.orElse(null);
    }

    public Explication createExplication(Explication explication) {

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.EXPLICATIONS, LogTag.CREATED), "Explication Created.");

        return explicationRepository.save(explication);
    }

    public Explication updateExplication(int id, Explication explication) {
        final Optional<Explication> explicationOptional = explicationRepository.findById(id);

        if (explicationOptional.isEmpty()) {
            throw new ExplicationNotFoundException(id);
        }

        Explication explicationUpdated = explicationOptional.get();

        // TODO: 21/10/2023 FIX THIS METHOD

        explicationUpdated = new Explication.ExplicationBuilder(explicationUpdated) //
                .designation(explication.getDesignation()) //
                .description(explication.getDescription()) //
                .studyArea(explication.getStudyArea()) //
                .isRemote(explication.isRemote()) //
                .teacher(explication.getTeacher()) //
                .active(explication.isActive()) //
                .build();

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.EXPLICATIONS, LogTag.UPDATED), MessageFormat.format("Explication {0} Updated.", id));

        return explicationRepository.save(explicationUpdated);
    }

    public void deleteExplication(int id) {
        final Optional<Explication> explicationOptional = explicationRepository.findById(id);

        if (explicationOptional.isEmpty()) {
            throw new ExplicationNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.EXPLICATIONS, LogTag.DELETED), MessageFormat.format("Explication {0} deleted.", id));

        explicationRepository.deleteById(id);
    }
}
