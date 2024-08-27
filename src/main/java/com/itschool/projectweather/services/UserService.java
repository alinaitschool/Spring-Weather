package com.itschool.projectweather.services;

import com.itschool.projectweather.models.dtos.UserDTO;
import com.itschool.projectweather.models.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserService {


    User getUser(Long id);

    UserDTO updateUser(UserDTO userDTO);

    List<UserDTO> getUsers();
    void deleteUser(Long id);

    UserDTO createUserDTO(UserDTO userDTO);
}
