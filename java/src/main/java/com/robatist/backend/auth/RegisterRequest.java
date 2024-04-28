package com.robatist.backend.auth;

import com.robatist.backend.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private String nif;
    private String photo;
    private boolean isActive;
    private Role role;
}
