package com.example.AnimalShelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Основной класс приложения для запуска
 */
@SpringBootApplication
public class AnimalShelterApplication {

	/**
	 * Запуск приложения
	 * @param args различные аргументы
	 */
	public static void main(String[] args) {
		SpringApplication.run(AnimalShelterApplication.class, args);
	}

}
