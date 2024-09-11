package com.bycompany.projects.MovieManager.service;

import com.bycompany.projects.MovieManager.persistence.entity.Pelicula;
import com.bycompany.projects.MovieManager.util.MovieGenre;

import java.util.List;

public interface MovieService {

    List<Pelicula> findAll();

    List<Pelicula> findAllByTitle(String title);

    List<Pelicula> findAllByGenre(MovieGenre genre);

    List<Pelicula> findAllByGenreAndTitle(MovieGenre genre, String title);

    Pelicula findOneById(Long id);

    Pelicula createOne(Pelicula pelicula);

    Pelicula updateOneById(Long id, Pelicula pelicula);

    void deleteOneById(Long id);
}
