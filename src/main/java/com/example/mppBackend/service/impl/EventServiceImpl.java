package com.example.mppBackend.service.impl;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.exception.ResourceNotFoundException;
import com.example.mppBackend.mapper.EventMapper;
import com.example.mppBackend.repository.EventRepository;
import com.example.mppBackend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

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
        return events.stream().map((event)->EventMapper.mapToEventDto(event))
                .collect(Collectors.toList());
    }

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


}
