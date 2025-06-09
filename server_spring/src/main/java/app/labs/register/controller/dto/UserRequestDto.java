package app.labs.register.controller.dto;

import app.labs.register.domain.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private AuthProvider provider;
    private String kakaoToken;
}
