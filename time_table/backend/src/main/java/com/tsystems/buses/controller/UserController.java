package com.tsystems.buses.controller;

import com.tsystems.buses.services.UserService;
import com.tsystems.buses.model.PortalUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<PortalUserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{userId}")
    public PortalUserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/loginId/{loginId}")
    public PortalUserDto getUserByLoginId(@PathVariable String loginId) {
        return userService.findByLoginId(loginId);
    }
}
