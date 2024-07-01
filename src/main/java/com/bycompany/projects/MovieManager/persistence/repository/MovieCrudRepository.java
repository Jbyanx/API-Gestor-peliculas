package com.bycompany.projects.MovieManager.persistence.repository;

import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCrudRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitleContaining(String title);
    List<Movie> findByGenre(MovieGenre genre);
    List<Movie> findByGenreAndTitleContaining(MovieGenre genre, String title);

}
