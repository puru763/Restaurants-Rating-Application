package com.RestaurantsRatingApplication.UserService.controller;

import com.RestaurantsRatingApplication.UserService.entity.User;
import com.RestaurantsRatingApplication.UserService.exception.ResourceNotFoundException;
import com.RestaurantsRatingApplication.UserService.exception.UserServiceException;
import com.RestaurantsRatingApplication.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.saveUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (UserServiceException e) {
            return ResponseEntity.badRequest().body(new Error("Error creating user: " + e.getMessage()));
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get Single User Handler: UserController");
        try {
            User user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> allUser = userService.getAllUser();
            return ResponseEntity.ok(allUser);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}