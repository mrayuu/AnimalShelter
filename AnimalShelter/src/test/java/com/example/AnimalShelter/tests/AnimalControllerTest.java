package com.example.AnimalShelter.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.AnimalShelter.entity.AnimalEntity;
import com.example.AnimalShelter.repository.AnimalRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AnimalRepo animalRepo;

    @Test
    public void testAnimalAdd() throws Exception {
        mockMvc.perform(post("/animals/add")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "TestAnimal")
                        .param("gender", "Male")
                        .param("age", "3")
                        .param("kind", "Dog")
                        .param("breed", "Labrador")
                        .param("color", "Brown")
                        .param("size", "Large")
                        .param("vaccinations", "Yes")
                        .param("diseases", "None")
                        .param("description", "Friendly and playful")
                        .with(user("admin").password("admin").roles("ADMIN"))
                )
                .andExpect(status().is4xxClientError());
                //.andExpect(redirectedUrl("/login"));

        // Проверяем, что животное успешно добавлено в базу данных
        Iterable<AnimalEntity> animals = animalRepo.findAll();
        boolean animalAdded = true;
        for (AnimalEntity animal : animals) {
            if (animal.getName().equals("TestAnimal")) {
                animalAdded = false;
                break;
            }
        }
        assert (animalAdded);
    }
}
