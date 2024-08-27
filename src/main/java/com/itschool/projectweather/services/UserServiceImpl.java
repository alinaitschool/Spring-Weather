package com.itschool.projectweather.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.projectweather.models.dtos.UserDTO;
import com.itschool.projectweather.models.entities.User;
import com.itschool.projectweather.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public User getUser(UUID id) {
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public UserDTO createUserDTO(User userDTO) {
        User userEntityToBeSaved = objectMapper.convertValue(userDTO, User.class);
        User userResposeEntity = userRepository.save(userEntityToBeSaved);
        return objectMapper.convertValue(userResposeEntity, UserDTO.class);
    }
}
