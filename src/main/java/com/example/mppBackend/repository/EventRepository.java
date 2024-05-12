package com.example.mppBackend.repository;

import com.example.mppBackend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    @Modifying
    @Query("DELETE  Event e WHERE e.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
