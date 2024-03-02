package com.example.AnimalShelter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Класс MvcConfig - это конфигурационный класс Spring, который реализует интерфейс WebMvcConfigurer.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Функция addViewControllers () добавляет контроллер представлений на определенный URL-адрес в реестре контроллеров представлений.
     * @param registry URL-адрес
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}
