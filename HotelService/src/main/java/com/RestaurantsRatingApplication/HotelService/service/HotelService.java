package com.RestaurantsRatingApplication.HotelService.service;

import com.RestaurantsRatingApplication.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel get(String id);
}
