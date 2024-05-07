package com.example.mppBackend.repository;

import com.example.mppBackend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {


}
