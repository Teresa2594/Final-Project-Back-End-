package com.ironhack.userInfoService.controller.interfaces;

import com.ironhack.userInfoService.model.User;

import java.util.List;

public interface IUserController {

    //  ******************************************************  GET  ******************************************************

    List<User> getAllUsers();

    User getUserInfo(Integer id);

    //  *****************************************************  POST  ******************************************************

    void saveUser(User user);

    //  *****************************************************  POST  ******************************************************

    void deleteUser(Integer id);

}
