package com.bycompany.projects.MovieManager.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "movie_id")
    private Long movieId;


    @Column(nullable = false, name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Usuario usuario;

    @Check(constraints = "rating >= 0 and rating <=5")
    @Column(nullable = false)
    private int rating;

    public Pelicula getMovie() {
        return pelicula;
    }

    public void setMovie(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }
}
