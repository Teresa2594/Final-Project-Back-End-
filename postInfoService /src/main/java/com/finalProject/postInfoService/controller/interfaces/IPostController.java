package com.finalProject.postInfoService.controller.interfaces;

import com.finalProject.postInfoService.model.Post;

import java.util.List;

public interface IPostController {

    //  ******************************************************  GET  ******************************************************
    List<Post> getAllPosts();
    Post getPostInfo(Integer id);

    List<Post> getPostByUserId(Integer userId);
    //  *****************************************************  POST  ******************************************************
    void savePost(Post post);
    //  *****************************************************  DELETE  ******************************************************
    void deletePost(Integer id);
}
