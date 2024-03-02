package com.example.AnimalShelter.exception;

/**
 * Исключение - пользователь уже существует. Нужно для проверки на верную регистрацию
 */
public class UserAlreadyExistException extends Exception{
    /**
     * Исключение - пользователь уже существует
     * @param message  сообщение
     */
    public UserAlreadyExistException (String message) {
        super(message);
    }
}
