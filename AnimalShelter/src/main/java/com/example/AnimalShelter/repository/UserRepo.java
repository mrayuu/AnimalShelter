package com.example.AnimalShelter.repository;
import com.example.AnimalShelter.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 * Класс `@Repository` является аннотацией Spring Framework, обозначающей, что этот класс является компонентом репозитория данных.
 * Этот класс используется для взаимодействия с базой данных и выполнения операций CRUD (создание, чтение, обновление и удаление).
 * Данный репозиторий нужен для работы с таблицей с пользователями
 */
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    /**
     * Отображение всех пользователей
     * @return все пользователи
     */
    List<UserEntity> findAll();

    /**
     * Поиск пользователя по уникальному номеру телефона
     * @param phone номер телефона
     * @return пользователь
     */
    UserEntity findByPhone(String phone);
}
