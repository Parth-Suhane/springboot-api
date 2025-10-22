package com.example.demo.controller.v1;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
