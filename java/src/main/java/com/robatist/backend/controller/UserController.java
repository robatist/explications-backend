package com.robatist.backend.controller;

import com.robatist.backend.service.UserService;
import com.robatist.backend.service.mapper.UserMapper;
import com.robatist.backend.service.model.user.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
public class UserController implements ApiController {

    private static final String BASE_PATH_PERSONS = "/persons";
    private static final String BASE_PATH_PERSONS_PLUS_ID_ENDPOINT = BASE_PATH_PERSONS + "/{id}";

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(final UserService userService, final UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(
            value = BASE_PATH_PERSONS,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMapper.mapUserListToUserDTOList(
                                userService.getAllUsers()
                        )
                );
    }

    @GetMapping(
            value = BASE_PATH_PERSONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMapper.mapUserToUserDTO(
                                userService.getUserById(id)
                        )
                );
    }

    @PostMapping(
            value = BASE_PATH_PERSONS,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMapper.mapUserToUserDTO(
                                userService.createUser(
                                        userMapper.mapUserDTOToUser(userDTO)
                                )
                        )
                );
    }

    @PutMapping(
            value = BASE_PATH_PERSONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDTO> updateUser(@PathVariable final int id, @RequestBody final UserDTO userDTO) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userMapper.mapUserToUserDTO(
                                userService.updateUser(
                                        id,
                                        userMapper.mapUserDTOToUser(userDTO)
                                )
                        )
                );
    }

    @DeleteMapping(
            value = BASE_PATH_PERSONS_PLUS_ID_ENDPOINT,
            produces = {"application/json"}
            // consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id) {

        // TODO: 24/10/2023 FIX THIS METHOD

        userService.deleteUser(id);
    }

}
