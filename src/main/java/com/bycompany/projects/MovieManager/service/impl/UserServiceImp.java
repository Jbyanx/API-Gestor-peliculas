package com.bycompany.projects.MovieManager.service.impl;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.User;
import com.bycompany.projects.MovieManager.persistence.repository.UserCrudRepository;
import com.bycompany.projects.MovieManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserCrudRepository userCrudRepository;

    @Override
    public List<User> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public List<User> findAllByName(String name) {
        return userCrudRepository.findAllByNameContaining(name);
    }

    @Override
    public User findOneByUsername(String username) {
        return userCrudRepository.findByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("[User username: "+username+"]"));
    }

    @Override
    public User createOne(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public User updateOneByUsername(String username, User user) {
        User user_bd = findOneByUsername(username);

        user_bd.setName(user.getName());
        user_bd.setPassword(user.getPassword());

        return userCrudRepository.save(user_bd);
    }

    @Override
    public void deleteByUsername(String username) {
//        User userToDelete = this.findOneByUsername(username);
//        userCrudRepository.delete(userToDelete);

        if(userCrudRepository.deleteByUsername(username) != 1 ){
            throw new ObjectNotFoundException("[User username: "+username+"]");
        }
    }
}
