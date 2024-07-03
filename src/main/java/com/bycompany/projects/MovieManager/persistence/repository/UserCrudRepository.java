package com.bycompany.projects.MovieManager.persistence.repository;

import com.bycompany.projects.MovieManager.persistence.entity.Rating;
import com.bycompany.projects.MovieManager.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User, Long> {

    List<User> findAllByNameContaining(String name);

    Optional<User> findByUsername(String username);

    Optional<User> updateByUsername(String username);

    @Modifying
    int deleteByUsername(String username);
}
