package com.bycompany.projects.MovieManager.service.impl;

import com.bycompany.projects.MovieManager.exception.ObjectNotFoundException;
import com.bycompany.projects.MovieManager.persistence.entity.Rating;
import com.bycompany.projects.MovieManager.persistence.repository.RatingCrudRepository;
import com.bycompany.projects.MovieManager.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImp implements RatingService {
    @Autowired
    RatingCrudRepository ratingCrudRepository;

    @Override
    public List<Rating> findAll() {
        return ratingCrudRepository.findAll();
    }

    @Override
    public List<Rating> findAllByMovieId(Long id) {
        return ratingCrudRepository.findByMovieId(id);
    }

    @Override
    public List<Rating> findAllByUsername(String username) {
        return ratingCrudRepository.findByUsername(username);
    }

    @Override
    public Rating findOneById(Long id) {
        return ratingCrudRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("[Rating id: "+id+"]"));
    }

    @Override
    public Rating createOne(Rating rating) {
        return ratingCrudRepository.save(rating);
    }

    @Override
    public Rating updateOneById(Long id, Rating rating) {
        Rating rating_bd = findOneById(id);

        rating_bd.setUserId(rating.getId());
        rating_bd.setMovieId(rating.getMovieId());

        return ratingCrudRepository.save(rating_bd);
    }

    @Override
    public void deleteOneById(Long id) {
        if(ratingCrudRepository.existsById(id)){
            ratingCrudRepository.deleteById(id);
            return;
        }
        throw new ObjectNotFoundException("[Rating: "+id+"]");
    }
}
