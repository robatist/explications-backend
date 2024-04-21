package com.robatist.backend.backend.controller;

import com.robatist.backend.backend.service.StudyAreaService;
import com.robatist.backend.backend.service.mapper.StudyAreaMapper;
import com.robatist.backend.backend.service.model.StudyAreaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
public class StudyAreaController implements ApiController {

    private static final String BASE_PATH_STUDY_AREAS = "/studyAreas";
    private static final String BASE_PATH_STUDY_AREAS_PLUS_ID_ENDPOINT = BASE_PATH_STUDY_AREAS + "/{id}";

    private final StudyAreaService studyAreaService;
    private final StudyAreaMapper studyAreaMapper;

    public StudyAreaController(final StudyAreaService studyAreaService, final StudyAreaMapper studyAreaMapper) {
        this.studyAreaService = studyAreaService;
        this.studyAreaMapper = studyAreaMapper;
    }

    @GetMapping(
            value = BASE_PATH_STUDY_AREAS,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<StudyAreaDTO>> getAllStudyAreas() {
        return ResponseEntity
                .ok()
                // .contentType(MediaType.APPLICATION_JSON)
                .body(studyAreaMapper.mapStudyAreaListToStudyAreaDTOList(
                                studyAreaService.getAllStudyAreas()
                        )
                );
    }

    @GetMapping(
            value = BASE_PATH_STUDY_AREAS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StudyAreaDTO> getStudyAreaById(@PathVariable int id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studyAreaMapper.mapStudyAreaToStudyAreaDTO(
                                studyAreaService.getStudyAreaById(id)
                        )
                );
    }

    @PostMapping(
            value = BASE_PATH_STUDY_AREAS,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudyAreaDTO> createStudyArea(@RequestBody StudyAreaDTO studyAreaDTO) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studyAreaMapper.mapStudyAreaToStudyAreaDTO(
                                studyAreaService.createStudyArea(
                                        studyAreaMapper.mapStudyAreaDTOToStudyArea(studyAreaDTO)
                                )
                        )
                );
    }

    @PutMapping(
            value = BASE_PATH_STUDY_AREAS_PLUS_ID_ENDPOINT,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StudyAreaDTO> updateStudyArea(@PathVariable int id, @RequestBody StudyAreaDTO studyAreaDTO) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(studyAreaMapper.mapStudyAreaToStudyAreaDTO(
                                studyAreaService.updateStudyArea(
                                        id,
                                        studyAreaMapper.mapStudyAreaDTOToStudyArea(studyAreaDTO))
                        )
                );
    }

    @DeleteMapping(
            value = BASE_PATH_STUDY_AREAS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudyArea(@PathVariable int id) {

        // TODO: 24/10/2023 FIX THIS METHOD

        studyAreaService.deleteStudyArea(id);
    }

}
