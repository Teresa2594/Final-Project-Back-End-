package com.finalProject.postInfoService.repository;

import com.finalProject.postInfoService.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostRepositoryTest {

    Post post = new Post(6,"Ciclismo y más ciclismo",null,"Ciclismo",2,"Pedaleando por el valle de Arán","");

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        Post post = new Post(6,"Ciclismo y más ciclismo",null,"Ciclismo",2,"Pedaleando por el valle de Arán","");
        postRepository.save(post);
    }

    @AfterEach
    public void tearDown() {
        postRepository.deleteById(6);
    }

    @Test
    public void findAll_post_postList() {
        List<Post> postList = postRepository.findAll();
        for (Post post: postList) {
            System.out.println(post);
        }
        assertEquals(6, postList.size());
    }

    @Test
    public void findById_validId_correctPost() {
        Optional<Post> post = postRepository.findById(1);
        assertTrue(post.isPresent());
        System.out.println(post.get());
        assertEquals("Nieve", post.get().getSection());
    }

    @Test
    public void findById_invalidId_postNotPresent() {
        Optional<Post> post = postRepository.findById(7);
        assertFalse(post.isPresent());
    }

    @Test
    public void findByUserId_validId_postPresent() {
        List<Post> posts = postRepository.findByuserId(2);
        assertEquals(4, posts.size());
    }
}
