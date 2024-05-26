package com.example.mppBackend;

import com.example.mppBackend.config.ApplicationConfig;
import com.example.mppBackend.entity.User;
import com.example.mppBackend.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = MppBackendApplication.class)
@ActiveProfiles("test") // Assuming you have a test profile setup
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password"); // Set other necessary fields
        userRepository.save(user);
    }

    @Test
    public void testFindByEmail() {
        Optional<User> user = userRepository.findByEmail("test@example.com");
        assertTrue(user.isPresent());
    }
}