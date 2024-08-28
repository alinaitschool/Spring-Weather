package com.itschool.projectweather.services;

import com.itschool.projectweather.models.dtos.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO updateUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getUsers();

    void deleteUser(Long id);

    UserDTO createUser(UserDTO userDTO);
}
