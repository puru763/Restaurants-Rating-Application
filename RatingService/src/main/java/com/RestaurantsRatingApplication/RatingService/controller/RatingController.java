package com.RestaurantsRatingApplication.RatingService.controller;

import com.RestaurantsRatingApplication.RatingService.entity.Rating;
import com.RestaurantsRatingApplication.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

//    @PostMapping("/create-rating")
//    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
//        try {
//            return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }


    @PostMapping("/create-rating")
    public ResponseEntity<?> create(@RequestBody Rating rating) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
        } catch (Exception ex) {
            // Log the exception for further analysis
            ex.printStackTrace();

            // Return a response with the error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
        }
    }

    @GetMapping("/get-rating")
    public ResponseEntity<List<Rating>> getRatings() {
        try {
            return ResponseEntity.ok(ratingService.getRatings());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-rating-by-userid/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        try {
            return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-rating-by-hotelid/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        try {
            return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}