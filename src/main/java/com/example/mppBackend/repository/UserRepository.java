package com.example.mppBackend.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.mppBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
