package com.RestaurantsRatingApplication.HotelService.exception;

public class HotelServiceException extends RuntimeException {

    public HotelServiceException(String message) {
        super(message);
    }

    public HotelServiceException() {
        super("Hotel service exception occurred");
    }
}