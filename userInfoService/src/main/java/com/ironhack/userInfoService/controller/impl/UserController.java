package com.ironhack.userInfoService.controller.impl;


import com.ironhack.userInfoService.controller.interfaces.IUserController;
import com.ironhack.userInfoService.model.User;
import com.ironhack.userInfoService.repository.UserRepository;
import com.ironhack.userInfoService.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController implements IUserController {

    @Autowired
    UserRepository usersRepository;

    @Autowired
    UserService userService;

    //  ******************************************************  GET  ******************************************************
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserInfo(@PathVariable Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    //  *****************************************************  POST  ******************************************************
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);

    }

    //  ****************************************************  DELETE  *****************************************************

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
