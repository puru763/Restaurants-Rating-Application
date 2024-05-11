package com.RestaurantsRatingApplication.HotelService.service.Impl;



import com.RestaurantsRatingApplication.HotelService.entity.Hotel;
import com.RestaurantsRatingApplication.HotelService.exception.HotelServiceException;
import com.RestaurantsRatingApplication.HotelService.exception.ResourceNotFoundException;
import com.RestaurantsRatingApplication.HotelService.repository.HotelRepository;
import com.RestaurantsRatingApplication.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        try {
            String hotelId = UUID.randomUUID().toString();
            hotel.setId(hotelId);
            return hotelRepository.save(hotel);
        } catch (DataAccessException ex) {
            throw new HotelServiceException("Error creating hotel: " + ex.getMessage());
        }
    }

    @Override
    public List<Hotel> getAll() {
        try {
            return hotelRepository.findAll();
        } catch (DataAccessException ex) {
            throw new HotelServiceException("Error retrieving all hotels: " + ex.getMessage());
        }
    }

    @Override
    public Hotel get(String id) {
        try {
            return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
        } catch (DataAccessException ex) {
            throw new HotelServiceException("Error retrieving hotel: " + ex.getMessage());
        }
    }
}