package com.RestaurantsRatingApplication.UserService.repository;

import com.RestaurantsRatingApplication.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository   extends JpaRepository<User, String> {

}