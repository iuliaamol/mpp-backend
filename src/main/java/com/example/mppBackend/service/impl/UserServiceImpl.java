package com.example.mppBackend.service.impl;

import com.example.mppBackend.dto.UserDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.entity.User;
import com.example.mppBackend.exception.ResourceNotFoundException;
import com.example.mppBackend.mapper.EventMapper;
import com.example.mppBackend.mapper.UserMapper;
import com.example.mppBackend.repository.UserRepository;
import com.example.mppBackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Invalid user"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream().map(user -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Invalid user"));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        User updatedUserDto=userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserDto);

    }

    @Override
    public void deleteUser(Long userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Invalid user"));

        userRepository.deleteById(userId);
    }
}
