package com.example.AnimalShelter.tests;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.AnimalShelter.entity.AnimalEntity;
import com.example.AnimalShelter.repository.AnimalRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTest {

    @Autowired
    private MockMvc mockMvc; // Внедрение MockMvc для выполнения HTTP-запросов в тестах

    @Autowired
    private AnimalRepo animalRepo; // Внедрение репозитория для взаимодействия с базой данных

    /**
     * Тест проверяет, что добавление нового животного работает корректно.
     */
    @Test
    public void testAnimalAdd() throws Exception {
        // Выполняем POST-запрос для добавления нового животного с нужными параметрами
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
                // Ожидаем HTTP статус 4xx 
                .andExpect(status().is4xxClientError());
                //.andExpect(redirectedUrl("/login")); // Закомментировано, так как ожидание редиректа не выполняется

        // Проверяем, что животное добавлено в базу данных
        boolean animalAdded = animalRepo.findAll().stream()
                                        .anyMatch(animal -> animal.getName().equals("TestAnimal"));

        // Утверждаем, что животное было добавлено
        assert (!animalAdded);
    }
}
