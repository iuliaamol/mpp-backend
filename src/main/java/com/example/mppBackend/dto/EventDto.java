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
    private Integer userId;//store just the id of the user

}
