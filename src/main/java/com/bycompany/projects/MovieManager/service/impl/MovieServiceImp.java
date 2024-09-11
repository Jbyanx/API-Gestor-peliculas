package com.bycompany.projects.MovieManager.service.impl;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Pelicula;
import com.bycompany.projects.MovieManager.persistence.repository.MovieCrudRepository;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    MovieCrudRepository movieCrudRepository;

    @Override
    public List<Pelicula> findAll() {
        return movieCrudRepository.findAll();
    }

    @Override
    public List<Pelicula> findAllByTitle(String title) {
        return movieCrudRepository.findByTitleContaining(title);
    }

    @Override
    public List<Pelicula> findAllByGenre(MovieGenre genre) {
        return movieCrudRepository.findByGenre(genre);
    }

    @Override
    public List<Pelicula> findAllByGenreAndTitle(MovieGenre genre, String title) {
        return movieCrudRepository.findByGenreAndTitleContaining(genre, title);
    }

    @Override
    /***
     * Buscar una Pelicula por su id
     * @Return null si la pelicula no existe
     * @Return Pelicula si la pelicula existe
     */
    public Pelicula findOneById(Long id) {
        return movieCrudRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("[movie: "+id+"]"));
    }

    @Override
    public Pelicula createOne(Pelicula pelicula) {
        return movieCrudRepository.save(pelicula);
    }

    @Override
    public Pelicula updateOneById(Long id, Pelicula pelicula) {
        Pelicula movie_bd = findOneById(id);

        movie_bd.setDirector(pelicula.getDirector());
        movie_bd.setGenre(pelicula.getGenre());
        movie_bd.setTitle(pelicula.getTitle());
        movie_bd.setReleaseYear(pelicula.getReleaseYear());

        return movieCrudRepository.save(movie_bd);
    }

    @Override
    public void deleteOneById(Long id) {
        Pelicula pelicula = findOneById(id);
        movieCrudRepository.delete(pelicula);
    }
}
