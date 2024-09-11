package com.bycompany.projects.MovieManager.service;

import com.bycompany.projects.MovieManager.persistence.entity.Usuario;

import java.util.List;

public interface UserService {

    List<Usuario> findAll();

    List<Usuario> findAllByName(String name);

    Usuario findOneByUsername(String username);

    Usuario createOne(Usuario usuario);

    Usuario updateOneByUsername(String username, Usuario usuario);

    void deleteByUsername(String username);
}
