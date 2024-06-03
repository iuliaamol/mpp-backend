package com.example.mppBackend.controller;

import com.example.mppBackend.config.JwtService;
import com.example.mppBackend.dto.EventDto;
import com.example.mppBackend.service.EventService;
import com.example.mppBackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

    private EventService  eventService;
    private UserService userService;
    private JwtService jwtService;

    //build add event rest api
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EventDto> createEvent( @RequestBody EventDto eventDto){
        EventDto savedEvent=eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    //build get event rest api
    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER')")
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

    //build update event rest api
    @PutMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long eventId,
                                                @RequestBody EventDto updatedEvent){
        EventDto eventDto=eventService.updateEvent(eventId,updatedEvent);
        return ResponseEntity.ok(eventDto);
    }

    //build delete event rest api
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<EventDto>> getAllEventsByUserId(@PathVariable("userId") Long userId) {
//        List<EventDto> eventDtos = eventService.getAllEventsByUserId(userId);
//        return ResponseEntity.ok(eventDtos);
//    }



    @GetMapping("/user")
    public ResponseEntity<List<EventDto>> getUserEvents(@RequestHeader("Authorization") String token) {
        try {
            System.out.println("String token: " + token.split(" ")[1]);
            String username = jwtService.getUsernameFromToken(token.split(" ")[1]);
           // System.out.println("String userId: " + userId);
            List<EventDto> userEvents = eventService.getAllEventsByUserId(username);

            return ResponseEntity.ok(userEvents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
