package com.bycompany.projects.MovieManager.persistence.repository;

import com.bycompany.projects.MovieManager.persistence.entity.Pelicula;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCrudRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByTitleContaining(String title);
    List<Pelicula> findByGenre(MovieGenre genre);
    List<Pelicula> findByGenreAndTitleContaining(MovieGenre genre, String title);

}
