package com.robatist.backend.controller;

import com.robatist.backend.auth.AuthenticationRequest;
import com.robatist.backend.auth.AuthenticationResponse;
import com.robatist.backend.auth.AuthenticationService;
import com.robatist.backend.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Transactional
@RestController
@RequiredArgsConstructor
public class AuthenticationController implements ApiController {

    private static final String BASE_PATH_AUTH = "/auth";

    private final AuthenticationService authenticationService;

    @PostMapping(BASE_PATH_AUTH + "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping(BASE_PATH_AUTH + "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping(BASE_PATH_AUTH + "/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }

}
