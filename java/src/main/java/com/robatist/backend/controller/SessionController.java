package com.robatist.backend.controller;

import com.robatist.backend.service.SessionService;
import com.robatist.backend.service.mapper.SessionMapper;
import com.robatist.backend.service.model.SessionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
public class SessionController implements ApiController {

    private static final String BASE_PATH_SESSIONS = "/sessions";
    private static final String BASE_PATH_SESSIONS_PLUS_ID_ENDPOINT = BASE_PATH_SESSIONS + "/{id}";

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    public SessionController(final SessionService sessionService, final SessionMapper sessionMapper) {
        this.sessionService = sessionService;
        this.sessionMapper = sessionMapper;
    }

    @GetMapping(
            value = BASE_PATH_SESSIONS,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<SessionDTO>> getAllSessions() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sessionMapper.mapSessionListToSessionDTOList(
                                sessionService.getAllSessions()
                        )
                );
    }

    @GetMapping(
            value = BASE_PATH_SESSIONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable int id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sessionMapper.mapSessionToSessionDTO(
                                sessionService.getSessionById(id)
                        )
                );
    }

    @PostMapping(
            value = BASE_PATH_SESSIONS,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessionDTO> createSession(@RequestBody SessionDTO sessionDTO) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sessionMapper.mapSessionToSessionDTO(
                                sessionService.createSession(
                                        sessionMapper.mapSessionDTOToSession(sessionDTO)
                                )
                        )
                );
    }

    @PutMapping(
            value = BASE_PATH_SESSIONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SessionDTO> updateSession(@PathVariable int id, @RequestBody SessionDTO sessionDTO) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(sessionMapper.mapSessionToSessionDTO(
                                sessionService.updateSession(
                                        id,
                                        sessionMapper.mapSessionDTOToSession(sessionDTO)
                                )
                        )
                );
    }

    @DeleteMapping(
            value = BASE_PATH_SESSIONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteSession(@PathVariable int id) {

        // TODO: 24/10/2023 FIX THIS METHOD

        sessionService.deleteSession(id);
    }

}
