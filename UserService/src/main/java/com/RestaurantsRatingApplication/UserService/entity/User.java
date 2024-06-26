package com.RestaurantsRatingApplication.UserService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "EMAIL")

    private String email;
    @Column(name = "ABOUT")
    private String about;



    //if we  dont want  to  store  rating in  user databse  then we  nedd to  use  this  annotation
    @Transient
    private List<Rating> ratings=new ArrayList<>();


}