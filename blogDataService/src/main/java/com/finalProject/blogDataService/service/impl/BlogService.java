package com.finalProject.blogDataService.service.impl;

import com.finalProject.blogDataService.client.*;


import com.finalProject.blogDataService.model.Blog;
import com.finalProject.blogDataService.model.Post;
import com.finalProject.blogDataService.model.User;

import com.finalProject.blogDataService.service.interfaces.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    @Autowired
    PostInfoService postInfoService;

    @Autowired
    UserInfoService userInfoService;

    public Blog getBlog(Long id) {
        User user = userInfoService.getUserInfo(id);
        List<Post> postList = postInfoService.getPostByUserId(id);
        Blog blog = new Blog();
        blog.setUser(user);
        blog.setPosts(postList);
        return blog;
    }
}
