package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.service.MovieService;
import com.bycompany.projects.MovieManager.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;



    @GetMapping(params = {"genre","title"})
    public List<Movie> findAllByGenreAndTitle(
            @RequestParam String title,
            @RequestParam MovieGenre genre)
    {
        System.out.println("findAllByGenreAndTitle");
        return movieService.findAllByGenreAndTitle(genre, title);
    }

    @GetMapping(params = "title")
    public List<Movie> findAllByTitle(@RequestParam String title)
    {

        System.out.println("findAllByTitle");
        return movieService.findAllByTitle(title);
    }

    @GetMapping(params = "genre")
    public List<Movie> findAllByGenre(@RequestParam MovieGenre genre){
        System.out.println("findAllByGenre");
        return movieService.findAllByGenre(genre);
    }

    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findOneById(@PathVariable Long id){
        return movieService.findOneById(id);
    }
}
