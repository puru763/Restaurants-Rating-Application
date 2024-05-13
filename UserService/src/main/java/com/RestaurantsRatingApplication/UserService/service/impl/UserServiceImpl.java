package com.RestaurantsRatingApplication.UserService.service.impl;

import com.RestaurantsRatingApplication.UserService.entity.Hotel;
import com.RestaurantsRatingApplication.UserService.entity.Rating;
import com.RestaurantsRatingApplication.UserService.entity.User;
import com.RestaurantsRatingApplication.UserService.exception.ResourceNotFoundException;
import com.RestaurantsRatingApplication.UserService.exception.UserServiceException;
import com.RestaurantsRatingApplication.UserService.external.HotelService;
import com.RestaurantsRatingApplication.UserService.repository.UserRepository;
import com.RestaurantsRatingApplication.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    public RestTemplate restTemplate;

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


//    @Override
//    public User getUser(String userId) {
//        try {
//            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
//            return user;
//        } catch (DataAccessException ex) {
//            throw new UserServiceException("Error retrieving user: " + ex.getMessage());
//        }
//    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        Rating[] ratingsOfUser = hotelService.getRatingsByUserId(userId); // Corrected parameter usage
        logger.info("{} ", ratingsOfUser);

        List<Rating> ratings = Arrays.asList(ratingsOfUser);
        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
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
