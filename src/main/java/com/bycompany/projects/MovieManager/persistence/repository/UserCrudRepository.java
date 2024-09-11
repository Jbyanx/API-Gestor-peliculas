package com.bycompany.projects.MovieManager.persistence.repository;

import com.bycompany.projects.MovieManager.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByNameContaining(String name);

    Optional<Usuario> findByUsername(String username);

    //Optional<Usuario> updateByUsername(String username);

    @Modifying
    int deleteByUsername(String username);
}
