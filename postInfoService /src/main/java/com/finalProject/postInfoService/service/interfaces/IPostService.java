package com.finalProject.postInfoService.service.interfaces;

import com.finalProject.postInfoService.model.Post;

public interface IPostService {
    void savePost(Post post);

    void deletePost(Integer id);
}
