package com.example.mppBackend.dto;

import com.example.mppBackend.entity.Event;
import com.example.mppBackend.entity.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;

    public UserDto(Integer id, String username, String email, String password, Role role) {
    }
}