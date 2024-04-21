package com.robatist.backend.backend.service;

import com.robatist.backend.backend.domain.Session;
import com.robatist.backend.backend.exception.SessionNotFoundException;
import com.robatist.backend.backend.exception.SessionsNotFoundException;
import com.robatist.backend.backend.logging.Logger;
import com.robatist.backend.backend.logging.enumeration.LogTag;
import com.robatist.backend.backend.repository.SessionRepository;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private static final Logger LOGGER = new Logger(UserService.class);
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(final SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {

        final List<Session> sessionList = sessionRepository.findAll();

        if (sessionList.isEmpty()) {
            throw new SessionsNotFoundException();
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.SESSIONS, LogTag.RETRIEVED), "All Sessions Retrieved.");

        return sessionList;
    }

    public Session getSessionById(int id) {
        final Optional<Session> sessionOptional = sessionRepository.findById(id);

        if (sessionOptional.isEmpty()) {
            throw new SessionNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.SESSIONS, LogTag.RETRIEVED),
                MessageFormat.format("Session {0} Retrieved.", id));

        return sessionOptional.get();
    }

    public Session createSession(Session session) {

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.SESSIONS, LogTag.CREATED), "Session Created.");

        return sessionRepository.save(session);
    }

    public Session updateSession(int id, Session session) {
        final Optional<Session> sessionOptional = sessionRepository.findById(id);

        if (sessionOptional.isEmpty()) {
            throw new SessionNotFoundException(id);
        }

        Session sessionUpdated = sessionOptional.get();

        // TODO: 21/10/2023 FIX THIS METHOD

       /*
        final User user = new User.UserBuilder() //
                .id() //
                .firstName() //
                .lastName() //
                .age() //
                .nif() //
                .photo() //
                .active() //
                .build();
        */

        sessionUpdated = new Session.SessionBuilder(sessionUpdated) //
                .designation(session.getDesignation()) //
                .sessionDate(session.getSessionDate()) //
                .student(session.getStudent()) //
                .explication(session.getExplication()) //
                .build();

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.SESSIONS, LogTag.UPDATED), MessageFormat.format("Session {0} Updated.", id));

        return sessionRepository.save(sessionUpdated);
    }

    public void deleteSession(int id) {
        final Optional<Session> sessionOptional = sessionRepository.findById(id);

        if (sessionOptional.isEmpty()) {
            throw new SessionNotFoundException(id);
        }

        LOGGER.info(MDC.get("correlationId"), Arrays.asList(LogTag.SESSIONS, LogTag.DELETED), MessageFormat.format("Session {0} deleted.", id));

        sessionRepository.deleteById(id);
    }

}
