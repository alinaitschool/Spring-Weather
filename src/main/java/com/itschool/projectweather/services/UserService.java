package com.itschool.projectweather.services;

import com.itschool.projectweather.models.dtos.UserDTO;
import com.itschool.projectweather.models.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {


    User getUser(UUID id);

    List<UserDTO> getUsers();
    void deleteUser(UUID id);

    UserDTO createUserDTO(User userDTO);
}
