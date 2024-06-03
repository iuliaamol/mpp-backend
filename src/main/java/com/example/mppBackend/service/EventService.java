package com.example.mppBackend.service;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto getEventById(Long eventId);
    List<EventDto> getAllEvents();
    EventDto updateEvent(Long eventId, EventDto updatedEvent);
    void deleteEvent(Long eventId);
    void deleteEventByUserId(Long userId);

    List<EventDto> getAllEventsByUserId(String username);




    //Page<EventDto> getAllEvents(Pageable pageable);
    //Page<Event> getEventsByUserId(Long userId, int pageNumber, int pageSize);
}
