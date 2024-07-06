package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> findAll(@RequestParam(required = false) String title,
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

        return  movies;
    }
    @GetMapping("/{id}")
    public Movie findOneById(@PathVariable Long id){
        return movieService.findOneById(id);
    }
}
