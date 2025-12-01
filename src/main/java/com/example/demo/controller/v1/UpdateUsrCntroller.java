package com.example.demo.controller.v1;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
@RequestMapping("/api/v1/user")
public class UpdateUsrCntroller {


    private UserService uservice;


    public UpdateUsrCntroller(UserService s) {
        uservice = s;
    }


    @PutMapping("/updte/{id}")
    public User updatUsr(@PathVariable("id") int i, @RequestBody Map<String, Object> body) {
        User u = uservice.getUserById((long) i);
        if (u == null) {
            return null;
        }

        if (body.containsKey("name")) {
            u.setName((String) body.get("name"));
        }
        if (body.containsKey("email")) {
            u.setEmail((String) body.get("email"));
        }

        return u;
    }
}