package com.RestaurantsRatingApplication.UserService.service;

import com.RestaurantsRatingApplication.UserService.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getUser(String userId);
}