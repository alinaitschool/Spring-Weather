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
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return objectMapper.convertValue(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userEntityConverted = users.stream().map(user -> objectMapper.convertValue(user, UserDTO.class)).toList();
        return userEntityConverted;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User userEntityToBeSaved = objectMapper.convertValue(userDTO, User.class);
        userRepository.save(userEntityToBeSaved);
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO createUserDTO(UserDTO userDTO) {
        User userEntityToBeSaved = objectMapper.convertValue(userDTO, User.class);
        User userResposeEntity = userRepository.save(userEntityToBeSaved);
        return objectMapper.convertValue(userResposeEntity, UserDTO.class);
    }
}
