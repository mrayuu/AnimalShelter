package com.example.AnimalShelter.exception;

/**
 * Класс UserNotFoundException используется для создания нового типа исключения,
 * которое может быть выброшено в случаях, когда пользователь не найден в системе.
 */
public class UserNotFoundException extends Exception {
    /**
     * Конструктор класса UserNotFoundException. Он принимает один параметр,
     * который представляет собой сообщение об ошибке, которое будет отображаться при выбрасывании исключения.
     * @param message сообщение об ошибке
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
