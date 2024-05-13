package com.RestaurantsRatingApplication.UserService.external;

import com.RestaurantsRatingApplication.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@FeignClient(name = "RatingService")
public interface RatingService {

    @PostMapping("/api/v1/rating/create-rating")
    public ResponseEntity<Rating> createRating(Rating values);



}