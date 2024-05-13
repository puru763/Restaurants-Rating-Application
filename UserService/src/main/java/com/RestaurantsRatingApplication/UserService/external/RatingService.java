package com.RestaurantsRatingApplication.UserService.external;

import com.RestaurantsRatingApplication.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RatingService")
public interface RatingService {

    @PostMapping("/api/v1/rating/create-rating")
    public ResponseEntity<Rating> createRating(Rating values);



}