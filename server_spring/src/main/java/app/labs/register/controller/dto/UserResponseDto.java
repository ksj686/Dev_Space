package app.labs.register.controller.dto;


import app.labs.register.domain.AuthProvider;
import app.labs.register.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String id;
    private String name;
    private String email;
    private String role;
    private AuthProvider provider;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.provider = user.getProvider();
    }
}
