package com.bycompany.projects.MovieManager.service.impl;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Usuario;
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
    public List<Usuario> findAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public List<Usuario> findAllByName(String name) {
        return userCrudRepository.findAllByNameContaining(name);
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return userCrudRepository.findByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("[Usuario username: "+username+"]"));
    }

    @Override
    public Usuario createOne(Usuario usuario) {
        return userCrudRepository.save(usuario);
    }

    @Override
    public Usuario updateOneByUsername(String username, Usuario usuario) {
        Usuario user_bd = findOneByUsername(username);

        user_bd.setName(usuario.getName());
        user_bd.setPassword(usuario.getPassword());

        return userCrudRepository.save(user_bd);
    }

    @Override
    public void deleteByUsername(String username) {
//        Usuario userToDelete = this.findOneByUsername(username);
//        userCrudRepository.delete(userToDelete);

        if(userCrudRepository.deleteByUsername(username) != 1 ){
            throw new ObjectNotFoundException("[Usuario username: "+username+"]");
        }
    }
}
