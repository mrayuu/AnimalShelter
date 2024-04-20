package com.example.AnimalShelter.tests;

import com.example.AnimalShelter.controller.UserController;
import com.example.AnimalShelter.entity.UserEntity;
import com.example.AnimalShelter.repository.UserRepo;
import com.example.AnimalShelter.entity.RoleEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepo;

    @InjectMocks
    private UserController userController;

    @Test
    public void testAddUser_Success() throws Exception {
        UserEntity user = new UserEntity();
        user.setPhone("1234567890");
        user.setPassword("password");
        when(userRepo.findByPhone(user.getPhone())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"phone\": \"1234567890\", \"password\": \"password\"}"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void testUserDelete_Success() throws Exception {
        UserEntity user = new UserEntity();
        user.setId(1L);
        when(userRepo.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.post("/user/{id}/remove", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(redirectedUrl("/user"));
    }
}
