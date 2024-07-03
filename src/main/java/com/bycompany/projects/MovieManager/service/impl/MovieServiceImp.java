package com.bycompany.projects.MovieManager.service.impl;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.persistence.repository.MovieCrudRepository;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    MovieCrudRepository movieCrudRepository;

    @Override
    public List<Movie> findAll() {
        return movieCrudRepository.findAll();
    }

    @Override
    public List<Movie> findAllByTitle(String title) {
        return movieCrudRepository.findByTitleContaining(title);
    }

    @Override
    public List<Movie> findAllByGenre(MovieGenre genre) {
        return movieCrudRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> findAllByGenreAndTitle(MovieGenre genre, String title) {
        return movieCrudRepository.findByGenreAndTitleContaining(genre, title);
    }

    @Override
    /***
     * Buscar una Pelicula por su id
     * @Return null si la pelicula no existe
     * @Return Movie si la pelicula existe
     */
    public Movie findOneById(Long id) {
        return movieCrudRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("[movie: "+id+"]"));
    }

    @Override
    public Movie createOne(Movie movie) {
        return movieCrudRepository.save(movie);
    }

    @Override
    public Movie updateOneById(Long id, Movie movie) {
        Movie movie_bd = findOneById(id);

        movie_bd.setDirector(movie.getDirector());
        movie_bd.setGenre(movie.getGenre());
        movie_bd.setTitle(movie.getTitle());
        movie_bd.setReleaseYear(movie.getReleaseYear());

        return movieCrudRepository.save(movie_bd);
    }

    @Override
    public void deleteOneById(Long id) {
        Movie movie = findOneById(id);
        movieCrudRepository.delete(movie);
    }
}
