package com.example.mppBackend.controller;

import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.entity.Event;
import com.example.mppBackend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService  eventService;

    //build add event rest api
    @PostMapping
    public ResponseEntity<EventDto> createEvent( @RequestBody EventDto eventDto){
        EventDto savedEvent=eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    //build get event rest api
    @GetMapping("{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id") Long eventId){
        EventDto eventDto=eventService.getEventById(eventId);
        return ResponseEntity.ok(eventDto);
    }

    //build getAll events rest api
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents(){
        List<EventDto> eventDtos=eventService.getAllEvents();
        return ResponseEntity.ok(eventDtos);
    }

//    @GetMapping("/events")
//    public ResponseEntity<Page<EventDto>> getAllEvents(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "50") int size) {
//        Page<EventDto> eventPage = (Page<EventDto>) eventService.getAllEvents(PageRequest.of(page, size));
//        return ResponseEntity.ok(eventPage);
//    }

    //build update event rest api
    @PutMapping("{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long eventId,
                                                @RequestBody EventDto updatedEvent){
        EventDto eventDto=eventService.updateEvent(eventId,updatedEvent);
        return ResponseEntity.ok(eventDto);
    }

    //build delete event rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }
}
