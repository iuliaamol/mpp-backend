package com.example.mppBackend.mapper;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.entity.User;

public class EventMapper {
    public static EventDto mapToEventDto(Event event){
        return new EventDto(
          event.getId(),
          event.getName(),
          event.getType(),
          event.getPrice(),
                event.getUser() != null ? event.getUser().getId() : null
        );
    }

    public static Event mapToEvent(EventDto eventDto){
        return new Event(
                eventDto.getId(),
                eventDto.getName(),
                eventDto.getType(),
                eventDto.getPrice(),
                new User(eventDto.getUserId(), null, null, null) // Assuming only user id is required to map
        );
    }
}
