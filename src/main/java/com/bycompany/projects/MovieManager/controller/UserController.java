package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.User;
import com.bycompany.projects.MovieManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(@RequestParam(required = false) String name){
        List<User> users = null;

        if(StringUtils.hasText(name)){
            users = userService.findAllByName(name);
        } else {
            users = userService.findAll();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{user}")
    public ResponseEntity<User> findOneByUsername(@PathVariable("user") String username){
        try {
            return ResponseEntity.ok(userService.findOneByUsername(username));
        } catch (ObjectNotFoundException ob){
            return ResponseEntity.notFound().build();
        }

    }
}
