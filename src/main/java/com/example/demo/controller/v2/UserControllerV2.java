package com.example.demo.controller.v2;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/users", headers = "X-API-VERSION=2")
public class UserControllerV2 {
    private final UserService service;
    public UserControllerV2(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getAll() { return service.getAllUsers(); }

    @PostMapping
    public User create(@Valid @RequestBody UserDto dto) { return service.createUser(dto); }
}
