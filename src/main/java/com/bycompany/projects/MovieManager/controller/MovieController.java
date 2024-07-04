package com.bycompany.projects.MovieManager.controller;

import com.bycompany.projects.MovieManager.persistence.entity.Movie;
import com.bycompany.projects.MovieManager.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> findAll(){
        return  movieService.findAll();
    }
}
