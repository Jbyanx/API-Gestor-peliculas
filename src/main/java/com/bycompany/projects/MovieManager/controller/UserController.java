package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.persistence.entity.User;
import com.bycompany.projects.MovieManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll(@RequestParam(required = false) String name){
        List<User> users = null;

        if(StringUtils.hasText(name)){
            users = userService.findAllByName(name);
        } else {
            users = userService.findAll();
        }

        return users;
    }

    @GetMapping("/{user}")
    public User findOneByUsername(@PathVariable("user") String username){
        return userService.findOneByUsername(username);
    }
}
