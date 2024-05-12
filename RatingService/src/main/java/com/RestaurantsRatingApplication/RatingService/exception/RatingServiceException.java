package com.RestaurantsRatingApplication.RatingService.exception;

public class RatingServiceException extends RuntimeException {

    public RatingServiceException(String message) {
        super(message);
    }

    public RatingServiceException() {
        super("Rating service exception occurred");
    }
}