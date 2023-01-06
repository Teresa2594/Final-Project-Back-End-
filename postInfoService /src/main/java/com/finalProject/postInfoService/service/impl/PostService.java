package com.finalProject.postInfoService.service.impl;

import com.finalProject.postInfoService.model.Post;
import com.finalProject.postInfoService.repository.PostRepository;
import com.finalProject.postInfoService.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    PostRepository postRepository;
    public void savePost(Post post) {
        postRepository.save(post);
    }


    public void deletePost(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        postRepository.deleteById(id);
    }
}
