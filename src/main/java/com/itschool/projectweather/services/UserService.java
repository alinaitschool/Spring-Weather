package com.itschool.projectweather.services;

import com.itschool.projectweather.models.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUser(User user);

    List<User> getUsers();
}
