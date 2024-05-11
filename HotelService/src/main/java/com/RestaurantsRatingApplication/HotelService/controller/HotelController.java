package com.RestaurantsRatingApplication.HotelService.controller;

import com.RestaurantsRatingApplication.HotelService.entity.Hotel;
import com.RestaurantsRatingApplication.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @PostMapping("/add-new-hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("get-hotel-by-hotel-id/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get-all-hotels")
    public ResponseEntity<List<Hotel>> getAll() {
        try {
            return ResponseEntity.ok(hotelService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
