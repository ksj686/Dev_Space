package app.labs.register.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.labs.register.controller.dto.UserRequestDto;
import app.labs.register.controller.dto.UserResponseDto;
import app.labs.register.domain.User;
import app.labs.register.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto) {
        User user = User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .provider(dto.getProvider())
                .kakaoToken(dto.getKakaoToken())
                .build();

        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(new UserResponseDto(savedUser));
    }
}
