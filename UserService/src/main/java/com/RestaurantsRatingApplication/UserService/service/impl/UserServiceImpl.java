package com.RestaurantsRatingApplication.UserService.service.impl;

import com.RestaurantsRatingApplication.UserService.entity.User;
import com.RestaurantsRatingApplication.UserService.exception.ResourceNotFoundException;
import com.RestaurantsRatingApplication.UserService.exception.UserServiceException;
import com.RestaurantsRatingApplication.UserService.repository.UserRepository;
import com.RestaurantsRatingApplication.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        try {
            String randomUserId = UUID.randomUUID().toString();
            user.setUserId(randomUserId);
            return userRepository.save(user);
        } catch (DataAccessException ex) {
            throw new UserServiceException("Error saving user: " + ex.getMessage());
        }
    }


    @Override
    public User getUser(String userId) {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
            return user;
        } catch (DataAccessException ex) {
            throw new UserServiceException("Error retrieving user: " + ex.getMessage());
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            return userRepository.findAll();
        } catch (DataAccessException ex) {
            throw new UserServiceException("Error retrieving all users: " + ex.getMessage());
        }
    }





}
