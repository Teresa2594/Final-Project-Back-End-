package com.ironhack.userInfoService.service.interfaces;

import com.ironhack.userInfoService.model.User;

public interface IUserService {
    void saveUser(User user);

    void deleteUser(Integer id);
}
