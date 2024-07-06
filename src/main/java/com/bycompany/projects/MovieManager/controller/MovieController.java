package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Movie>> findAll(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) MovieGenre genre){
        List<Movie> movies = null;

        if(StringUtils.hasText(title) && genre != null){
            movies = movieService.findAllByGenreAndTitle(genre, title);
        } else if(StringUtils.hasText(title)){
            movies = movieService.findAllByTitle(title);
        } else if(genre != null){
            movies = movieService.findAllByGenre(genre);
        } else {
            movies = movieService.findAll();
        }

        return ResponseEntity.ok(movies);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findOneById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(movieService.findOneById(id));
        }catch (ObjectNotFoundException ob){
            return  ResponseEntity.notFound().build();
        }

    }
}
