package com.rnb.springrestsecdemo.controller;

import com.rnb.springrestsecdemo.model.Role;
import com.rnb.springrestsecdemo.model.User;
import com.rnb.springrestsecdemo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * example of POST method: http://localhost:8080/rnb/register
 * input:
 *     {
 *         "id": 30,
 *         "username": "noName User",
 *         "password": "1234"
 *     }
 *
 * output:
 * {
 *     "id": 30,
 *     "username": "noName User",
 *     "password": "$2a$10$MF4Bly8q8zQkj6cIJPVqeO9FkF00NidoLkZBsqzYdYelUsW7HZ11C",
 *     "roles": [
 *         {
 *             "id": 0,
 *             "roleName": "ROLE_USER"
 *         }
 *     ]
 * }
 */
@RestController
@RequestMapping("/rnb")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setRoles(List.of(new Role("ROLE_USER")));
        User savedUser = userService.saveUser(user);
        return savedUser;
    }

    /*  user
        p!123
        $2a$10$qNkHbOTIUCt4X4lyvqwzde/wjTiDQ.iHWktUkvc3mTMZkUhKUxmwe

        password!123
        $2a$10$CsCM0IOgz5aH5lOKlHC9CuJ2xjLEfM6t0tTfKk6h1iI5h.tNjBXwK
     */
}
