package com.example.mppBackend.service;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);


}
