package com.RestaurantsRatingApplication.HotelService.repository;

import com.RestaurantsRatingApplication.HotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository  extends JpaRepository<Hotel, String> {
}
