package com.bycompany.projects.MovieManager.persistence.repository;

import com.bycompany.projects.MovieManager.persistence.entity.Rating;
import com.bycompany.projects.MovieManager.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingCrudRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByMovieId(long id);

    List<Rating> findByUserUsername(String Username);

    @Query("SELECT r FROM Rating r JOIN r.user u WHERE u.username = ?1")
    List<Rating> findByUsername(String username);
}
