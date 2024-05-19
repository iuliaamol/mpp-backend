package com.example.mppBackend.utils;

import com.example.mppBackend.entity.Event;
import com.example.mppBackend.entity.User;
import com.example.mppBackend.repository.EventRepository;
import com.example.mppBackend.repository.UserRepository;
import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class DataGenerator implements CommandLineRunner {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    private static final int NUM_USERS=1000;
//    private static final int EVENTS_PER_USER=100;
//
//    @Override
//    @Transactional
//    public void run(String... args){
//        Faker faker= new Faker();
//
//        // Generate and save users
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < NUM_USERS; i++) {
//            User user = new User();
//            user.setUsername(faker.name().username());
//            user.setEmail(faker.internet().emailAddress());
//            user.setPassword(faker.internet().password());
//            users.add(user);
//        }
//        userRepository.saveAll(users);
//
//
//        // Generate and save events for each user
//        for (User user : users) {
//            List<Event> events = new ArrayList<>();
//            for (int j = 0; j < EVENTS_PER_USER; j++) {
//                Event event = new Event();
//                event.setName(faker.book().title());
//                event.setType(faker.book().genre());
//                event.setPrice(faker.number().randomDouble(2, 10, 100));
//                event.setUser(user);
//                events.add(event);
//            }
//            eventRepository.saveAll(events);
//        }
//
//    }
//
//}
