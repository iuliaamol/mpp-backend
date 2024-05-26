package com.example.mppBackend.mapper;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.entity.User;

public class EventMapper {
    public static EventDto mapToEventDto(Event event) {
        // Map Event entity to EventDto
        return new EventDto(
                event.getId(),
                event.getName(),
                event.getType(),
                event.getPrice(),
                event.getUser() != null ? event.getUser().getId() : null
        );
    }

    public static Event mapToEvent(EventDto eventDto) {
        // Map EventDto to Event entity
        Event event = new Event();
        event.setId(eventDto.getId());
        event.setName(eventDto.getName());
        event.setType(eventDto.getType());
        event.setPrice(eventDto.getPrice());

        // If only user ID is needed in the Event entity
        if (eventDto.getUserId() != null) {
            User user = new User();
            user.setId(Math.toIntExact(eventDto.getUserId()));
            event.setUser(user);
        }

        return event;
    }
}
