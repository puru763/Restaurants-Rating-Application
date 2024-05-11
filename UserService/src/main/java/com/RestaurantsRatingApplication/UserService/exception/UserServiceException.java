package com.RestaurantsRatingApplication.UserService.exception;

public class UserServiceException extends RuntimeException {

    public UserServiceException() {
        super(" exception occurred  while   creating an user ");
    }

    public UserServiceException(String message) {
        super(message);
    }
}