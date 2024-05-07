package com.example.mppBackend.dto;

import com.example.mppBackend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private String type;
    private double price;
    private Long userId;//store just the id of the user
}
