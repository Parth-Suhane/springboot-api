package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
    public User save(String name, String email) {
        Long id = counter.getAndIncrement();
        User user = new User(id, name, email);
        users.put(id, user);
        return user;
    }
}
