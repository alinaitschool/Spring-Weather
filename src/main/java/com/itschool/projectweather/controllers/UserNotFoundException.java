package com.itschool.projectweather.controllers;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(UUID id) {
        super(id.toString());
    }
}
