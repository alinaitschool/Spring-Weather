package com.itschool.projectweather.services;

import com.itschool.projectweather.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        if (user.getEmail().length() < 3) {
            throw new RuntimeException("Invalid email address.");
        }
        user.setId(UUID.randomUUID());
        users.add(user);
        log.info("User was saved!", user.getId());
        return user;
    }

    @Override
    public User getUser(UUID id) {
        return users.stream().filter(u-> u.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void deleteUser(UUID id) {
        User deleteUser = users.stream().filter(user->user.getId().equals(id)).findFirst().orElse(null);
        users.remove(deleteUser);
    }
}
