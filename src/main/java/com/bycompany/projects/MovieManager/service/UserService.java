package com.bycompany.projects.MovieManager.service;

import com.bycompany.projects.MovieManager.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> findAllByName(String name);

    User findOneByUsername(String username);

    User createOne(User user);

    User updateOneByUsername(String username, User user);

    void deleteByUsername(String username);
}
