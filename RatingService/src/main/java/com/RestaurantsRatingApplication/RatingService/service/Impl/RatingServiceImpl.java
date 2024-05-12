package com.RestaurantsRatingApplication.RatingService.service.Impl;

import com.RestaurantsRatingApplication.RatingService.entity.Rating;
import com.RestaurantsRatingApplication.RatingService.exception.RatingServiceException;
import com.RestaurantsRatingApplication.RatingService.repository.RatingRepository;
import com.RestaurantsRatingApplication.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        try {
            return repository.save(rating);
        } catch (DataAccessException ex) {
            throw new RatingServiceException("Error creating rating: " + ex.getMessage());
        }
    }

    @Override
    public List<Rating> getRatings() {
        try {
            return repository.findAll();
        } catch (DataAccessException ex) {
            throw new RatingServiceException("Error retrieving ratings: " + ex.getMessage());
        }
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        try {
            return repository.findByUserId(userId);
        } catch (DataAccessException ex) {
            throw new RatingServiceException("Error retrieving ratings by user ID: " + ex.getMessage());
        }
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        try {
            return repository.findByHotelId(hotelId);
        } catch (DataAccessException ex) {
            throw new RatingServiceException("Error retrieving ratings by hotel ID: " + ex.getMessage());
        }
    }
}