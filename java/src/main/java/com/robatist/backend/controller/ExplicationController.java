package com.robatist.backend.controller;

import com.robatist.backend.kafka.producer.KafkaProducer;
import com.robatist.backend.service.ExplicationService;
import com.robatist.backend.service.mapper.ExplicationMapper;
import com.robatist.backend.service.model.ExplicationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
public class ExplicationController implements ApiController {

    private static final String BASE_PATH_EXPLICATIONS = "/explications";
    private static final String BASE_PATH_EXPLICATIONS_PLUS_ID_ENDPOINT = BASE_PATH_EXPLICATIONS + "/{id}";

    private final KafkaProducer kafkaProducer;
    private final ExplicationService explicationService;
    private final ExplicationMapper explicationMapper;

    public ExplicationController(final KafkaProducer kafkaProducer, final ExplicationService explicationService, final ExplicationMapper explicationMapper) {
        this.kafkaProducer = kafkaProducer;
        this.explicationService = explicationService;
        this.explicationMapper = explicationMapper;
    }

    @GetMapping(
            value = BASE_PATH_EXPLICATIONS,
            produces = {MediaType.APPLICATION_JSON_VALUE}
            // consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ExplicationDTO>> getAllExplications() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(explicationMapper.mapExplicationListToExplicationDTOList(
                                explicationService.getAllExplications()
                        )
                );
    }

    @GetMapping(
            value = BASE_PATH_EXPLICATIONS_PLUS_ID_ENDPOINT,
            produces = {MediaType.APPLICATION_JSON_VALUE}
            // consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExplicationDTO> getExplicationById(@PathVariable int id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(explicationMapper.mapExplicationToExplicationDTO(
                                explicationService.getExplicationById(id)
                        )
                );
    }

    @PostMapping(
            value = BASE_PATH_EXPLICATIONS,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExplicationDTO> createExplication(@RequestBody ExplicationDTO explicationDTO) {
        var body = explicationMapper.mapExplicationToExplicationDTO(
                explicationService.createExplication(
                        explicationMapper.mapExplicationDTOToExplication(explicationDTO)
                )
        );

        // todo: 24/10/2023 send message to kafka as a json string
        kafkaProducer.sendMessage(body.toString());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @PutMapping(
            value = BASE_PATH_EXPLICATIONS_PLUS_ID_ENDPOINT,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ExplicationDTO> updateExplication(@PathVariable int id, @RequestBody ExplicationDTO explicationDTO) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(explicationMapper.mapExplicationToExplicationDTO(
                                explicationService.updateExplication(
                                        id,
                                        explicationMapper.mapExplicationDTOToExplication(explicationDTO)
                                )
                        )
                );
    }

    @DeleteMapping(
            value = BASE_PATH_EXPLICATIONS_PLUS_ID_ENDPOINT,
            produces = {MediaType.APPLICATION_JSON_VALUE}
            // consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteExplication(@PathVariable int id) {

        // TODO: 24/10/2023 FIX THIS METHOD

        explicationService.deleteExplication(id);
    }

}
