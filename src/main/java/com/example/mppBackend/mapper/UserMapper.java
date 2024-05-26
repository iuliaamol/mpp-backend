package com.example.mppBackend.mapper;

import com.example.mppBackend.dto.UserDto;
import com.example.mppBackend.entity.User;
import com.example.mppBackend.entity.Event;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole()
                );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                Math.toIntExact(userDto.getId()),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRole()

                );
    }
}
