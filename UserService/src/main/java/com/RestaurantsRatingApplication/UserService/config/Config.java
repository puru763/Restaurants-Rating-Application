package com.RestaurantsRatingApplication.UserService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Config {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }


}
