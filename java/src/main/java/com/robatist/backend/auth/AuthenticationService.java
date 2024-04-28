package com.robatist.backend.auth;

import com.robatist.backend.config.JwtService;
import com.robatist.backend.domain.user.Role;
import com.robatist.backend.domain.user.User;
import com.robatist.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new User.UserBuilder() //
                .firstName(request.getFirstName()) //
                .lastName(request.getLastName()) //
                .email(request.getEmail()) //
                .password(passwordEncoder.encode(request.getPassword())) //
                .age(request.getAge()) //
                .nif(request.getNif()) //
                .photo(request.getPhoto()) //
                .active(request.isActive()) //
                .role(Role.USER) //
                .build();

        userService.createUser(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder() //
                .token(jwtToken) //
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );

        var user = userService.getUserByEmail(request.getEmail());

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder() //
                .token(jwtToken) //
                .build();
    }
}
