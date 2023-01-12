package com.ironhack.userInfoService.service.interfaces;

import com.ironhack.userInfoService.model.User;

import java.util.List;

public interface IUserService {
    User saveUser(User userSignupDTO);

    void deleteUser(Long id);

    List<User> getUsers();

}
