package com.example.demo.controller.v1;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UpdateUsrCntrollerTest {

    private UserService userService;
    private UpdateUsrCntroller controller;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        controller = new UpdateUsrCntroller(userService);
    }

    @Test
    void testUpdateUser_successfulUpdate() {
        User existing = new User(1L, "Old Name", "old@email.com");
        when(userService.getUserById(1L)).thenReturn(existing);

        Map<String, Object> body = new HashMap<>();
        body.put("name", "New Name");
        body.put("email", "new@email.com");

        User updated = controller.updatUsr(1, body);

        assertThat(updated.getName()).isEqualTo("New Name");
        assertThat(updated.getEmail()).isEqualTo("new@email.com");

        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testUpdateUser_userNotFound_returnsNull() {
        when(userService.getUserById(1L)).thenReturn(null);

        User result = controller.updatUsr(1, new HashMap<>());

        assertThat(result).isNull();
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testUpdateUser_partialUpdate() {
        User existing = new User(1L, "John", "john@example.com");
        when(userService.getUserById(1L)).thenReturn(existing);

        Map<String, Object> body = new HashMap<>();
        body.put("email", "updated@example.com");

        User updated = controller.updatUsr(1, body);

        assertThat(updated.getName()).isEqualTo("John"); // unchanged
        assertThat(updated.getEmail()).isEqualTo("updated@example.com");
    }
}
