package com.ironhack.userInfoService.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.userInfoService.model.User;
import com.ironhack.userInfoService.repository.UserRepository;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserControllerTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    void getAllUsers_validRequest_allUsers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Maite"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Carlos"));
    }

    @Test
    void getUserById_validId_correctUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/users/2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("23"));

    }


    @Test
    void saveUser_validUser_userSaved() throws Exception {
        User user = new User(4,"Teresa Mira","@Tere","hola@gmail.com","C/Sant Antoni","Aielo de Malferit",25,"Female",null);
        String body = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/api/users").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Teresa"));

        mockMvc.perform(delete("/api/users/4"))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void deleteUser() throws Exception {
        User user = new User(4,"Teresa Mira","@Tere","hola@gmail.com","C/Sant Antoni","Aielo de Malferit",25,"Female",null);
        String body = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/api/users").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        mockMvc.perform(delete("/api/users/4"))
                .andExpect(status().isNoContent())
                .andReturn();

        MvcResult mvcResult = mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Teresa"));
    }


}
