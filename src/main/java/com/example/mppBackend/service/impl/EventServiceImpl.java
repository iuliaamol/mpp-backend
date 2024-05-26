package com.example.mppBackend.service.impl;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.exception.ResourceNotFoundException;
import com.example.mppBackend.mapper.EventMapper;
import com.example.mppBackend.repository.EventRepository;
import com.example.mppBackend.service.EventService;
import com.example.mppBackend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserService userService;

    @Override
    public EventDto createEvent(EventDto eventDto) {

        Event event= EventMapper.mapToEvent(eventDto);
        Event savedEvent= eventRepository.save(event);
        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Event event =eventRepository.findById(eventId)
                .orElseThrow(()->new ResourceNotFoundException("Invalid Event"));
        return EventMapper.mapToEventDto(event);

    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events =eventRepository.findAll();
        return events.stream().map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public Page<EventDto> getAllEvents(Pageable pageable) {
//        Page<Event> eventPage = eventRepository.findAll(pageable);
//        return eventPage.map(EventMapper::mapToEventDto);
//    }

    @Override
    public EventDto updateEvent(Long eventId, EventDto updatedEvent) {
        Event event=eventRepository.findById(eventId).orElseThrow(
                ()-> new ResourceNotFoundException("Invalid event")
        );
        event.setName(updatedEvent.getName());
        event.setType(updatedEvent.getType());
        event.setPrice(updatedEvent.getPrice());
        Event updatedEventDto= eventRepository.save(event);

        return EventMapper.mapToEventDto(updatedEventDto);
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event=eventRepository.findById(eventId).orElseThrow(
                ()-> new ResourceNotFoundException("Invalid event")
        );
        eventRepository.deleteById(eventId);
    }

    @Override
    @Transactional
    public void deleteEventByUserId(Long userId){
        eventRepository.deleteByUserId(userId);
    }

//    @Override
//    public Page<Event> getEventsByUserId(Long userId, int pageNumber, int pageSize) {
//        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
//        return eventRepository.findByUserId(userId, pageRequest);
//    }

    @Override
    public List<EventDto> getAllEventsByUserId(Long userId) {
        List<Event> events = eventRepository.findByUserId(userId);
        return events.stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<EventDto> getAllEventsByUsername(String username) {
        // Retrieve user ID corresponding to the username
        Long userId = userService.getUserIdByUsername(username);

        // Fetch events associated with the user ID
        List<Event> events = eventRepository.findByUserId(userId);

        // Map events to EventDto objects
        return events.stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }
}
