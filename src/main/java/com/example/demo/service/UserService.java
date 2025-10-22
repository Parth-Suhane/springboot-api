package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.InMemoryUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final InMemoryUserRepository repo;
    public UserService(InMemoryUserRepository repo) { this.repo = repo; }

    public List<User> getAllUsers() { return repo.findAll(); }
    public User createUser(UserDto dto) { return repo.save(dto.getName(), dto.getEmail()); }
}
