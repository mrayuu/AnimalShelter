package com.example.AnimalShelter.service;
import com.example.AnimalShelter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service - аннотация, которая указывает, что класс является сервисом и содержит бизнес-логику приложения.
 * public class UserService - класс сервиса для работы с сущностями пользователей.
 * implements UserDetailsService - класс реализует интерфейс UserDetailsService, который используется для авторизации в приложении.
 */
@Service
public class UserService implements UserDetailsService {
    /**
     * импорт функций класса UserRepo, который используется для работы с базой данных
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * Метод для поиска пользователя по номеру телефона
     * @param phone номер телефона
     * @return пользователь с данным номером телефона
     * @throws UsernameNotFoundException  исключение, которое выбрасывается, если пользователя с заданным номером телефона не существует
     */
    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        return userRepo.findByPhone(phone);
    }
}

