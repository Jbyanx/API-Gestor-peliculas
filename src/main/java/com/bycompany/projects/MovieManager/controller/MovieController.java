package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Pelicula;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> findAll(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) MovieGenre genre){
        List<Pelicula> peliculas = null;

        if(StringUtils.hasText(title) && genre != null){
            peliculas = movieService.findAllByGenreAndTitle(genre, title);
        } else if(StringUtils.hasText(title)){
            peliculas = movieService.findAllByTitle(title);
        } else if(genre != null){
            peliculas = movieService.findAllByGenre(genre);
        } else {
            peliculas = movieService.findAll();
        }

        return ResponseEntity.ok(peliculas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> findOneById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(movieService.findOneById(id));
        }catch (ObjectNotFoundException ob){
            return  ResponseEntity.notFound().build();
        }

    }
}
