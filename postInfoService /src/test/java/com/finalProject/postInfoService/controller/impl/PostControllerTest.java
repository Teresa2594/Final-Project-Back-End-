package com.finalProject.postInfoService.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.postInfoService.model.Post;
import com.finalProject.postInfoService.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
 class PostControllerTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getAllPosts_validRequest_allPosts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ciclismo"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Nieve"));

    }

    @Test
    void getPostById_validId_correctPost() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("semana"));
    }

    @Test
    void getPostByUserId_validUserId_correctPost() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/postsUser/2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Nieve"));
    }

    @Test
    void savePost_validPost_postSaved() throws Exception {

        Post post = new Post(6,"Ciclismo y más ciclismo",null,"Ciclismo",2,"Pedaleando por el valle de Arán","");

        String body = objectMapper.writeValueAsString(post);

        mockMvc.perform(post("/api/posts").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ciclismo"));

        mockMvc.perform(delete("/api/posts/6"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void deletePost() throws Exception {
        Post post = new Post(6,"Ciclismo y más ciclismo",null,"Ciclismo",2,"Pedaleando por el valle de Arán","");
        String body = objectMapper.writeValueAsString(post);

        mockMvc.perform(post("/api/posts").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(delete("/api/posts/6"))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Pedaleando"));
    }

}
