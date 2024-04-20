package com.example.AnimalShelter.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")) // Perform a GET request to the home page URL
                .andExpect(MockMvcResultMatchers.status().isOk()) // Expect HTTP status code 200 (OK)
                .andExpect(MockMvcResultMatchers.view().name("home")); // Expect the view name to be "index"
    }
}
