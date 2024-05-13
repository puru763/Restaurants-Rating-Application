package com.RestaurantsRatingApplication.UserService.external;


import com.RestaurantsRatingApplication.UserService.entity.Hotel;
import com.RestaurantsRatingApplication.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HotelService")
public interface HotelService {

    @GetMapping("/ratings/users/{userId}")
    Rating[] getRatingsByUserId(@PathVariable("userId") String userId);

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
}