package com.itschool.projectweather.models.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
        private String firstName;
        private String lastName;
        private Long id;
        private String email;
}