package com.example.AnimalShelter.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Тестовый класс для проверки функциональности главной страницы.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc; // Внедрение MockMvc для выполнения HTTP-запросов в тестах

    /**
     * Тест проверяет, что домашняя страница возвращает корректный статус и отображает нужное представление.
     */
    @Test
    public void testHomePage() throws Exception {
        // Выполняем GET-запрос к URL главной страницы
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                // Ожидаем HTTP статус 200 (OK)
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Ожидаем, что представление будет иметь имя "home"
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }
}

