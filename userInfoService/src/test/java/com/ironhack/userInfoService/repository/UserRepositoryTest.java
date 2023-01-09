package com.ironhack.userInfoService.repository;

import com.ironhack.userInfoService.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = new User(4,"Teresa Mira","@Tere","hola@gmail.com","C/Sant Antoni","Aielo de Malferit",25,"Female",null);
        userRepository.save(user);
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteById(4);
    }

    @Test
    public void findAll_users_usersList() {
        List<User> userList = userRepository.findAll();
        assertEquals(3, userList.size());
    }

    @Test
    public void findById_validId_correctUser() {
        Optional<User> user = userRepository.findById(2);
        assertTrue(user.isPresent());
        assertEquals(23, user.get().getAge());
    }

    @Test
    public void findById_invalidId_userNotPresent() {
        Optional<User> user = userRepository.findById(5);
        assertFalse(user.isPresent());
    }

    @Test
    public void findByEmail_validEmail_correctUser() {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail("maite2594@gmail.com"));
        assertTrue(user.isPresent());
    }

    @Test
    public void findByEmail_invalidEmail_UserNotPresent() {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail("maite259@gmail.com"));
        assertFalse(user.isPresent());
    }


}
