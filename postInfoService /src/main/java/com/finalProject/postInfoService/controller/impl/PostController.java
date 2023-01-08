package com.finalProject.postInfoService.controller.impl;

import com.finalProject.postInfoService.controller.interfaces.IPostController;
import com.finalProject.postInfoService.model.Post;
import com.finalProject.postInfoService.repository.PostRepository;
import com.finalProject.postInfoService.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController implements IPostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;


    //  ******************************************************  GET  ******************************************************
    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPostInfo(@PathVariable Integer id){
        return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));
    }

    @GetMapping("/postsUser/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostByUserId(@PathVariable Integer userId) {
        return postRepository.findByuserId(userId);
    }



    //  ******************************************************  POST  ******************************************************
    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody Post post) {
        postService.savePost(post);

    }

    //  ******************************************************  DELETE  ******************************************************
    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);

    }
}
