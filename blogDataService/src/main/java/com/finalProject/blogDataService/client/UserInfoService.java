package com.finalProject.blogDataService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import  com.finalProject.blogDataService.model.User;


import java.util.List;

@FeignClient ("user-info-service")
public interface UserInfoService  {

    //  ******************************************************  GET  ******************************************************
    @GetMapping("api/users")
    List<User> getAllUsers();

    @GetMapping("api/users/{id}")
    User getUserInfo (@PathVariable Integer id);

}
