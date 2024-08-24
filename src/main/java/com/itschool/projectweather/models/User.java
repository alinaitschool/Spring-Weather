package com.itschool.projectweather.models;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private String firstName;
    private String lastName;
    private String location;
    private UUID id;
    private String email;
}
