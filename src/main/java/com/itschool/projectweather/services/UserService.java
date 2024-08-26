package com.itschool.projectweather.services;

import com.itschool.projectweather.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(User user);

    User getUser(UUID id);

    List<User> getUsers();
    void deleteUser(UUID id);
}
