package com.example.mppBackend.dto;

import com.example.mppBackend.entity.User;
import lombok.*;

@Data
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

    public EventDto(Long id, String name, String type, double price, Integer integer) {
    }
}
