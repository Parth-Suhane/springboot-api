package com.example.demo.controller.graphql;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphQLController {

    private final UserService userService;

    public UserGraphQLController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        // manually construct UserDto to reuse validation logic
        UserDto dto = new UserDto();
        dto.setName(name);
        dto.setEmail(email);

        // perform validation manually
        return userService.createUser(dto);
    }
}
