package com.example.demo.controller.v1;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "User management API")
@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {
    private final UserService service;
    public UserControllerV1(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getUsers() { return service.getAllUsers(); }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto dto) {
        return service.createUser(dto);
    }
}
