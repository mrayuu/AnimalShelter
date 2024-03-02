package com.example.AnimalShelter.entity;
import org.springframework.security.core.GrantedAuthority;
/**
 * Этот код описывает класс перечислений RoleEntity, который реализует интерфейс GrantedAuthority.
 * Перечисление RoleEntity описывает две роли: USER и ADMIN.
 * Интерфейс GrantedAuthority используется для предоставления информации о ролях, которые имеет пользователя.
 */
public enum RoleEntity implements GrantedAuthority {
    /**
     * Обычный пользователь
     */
    USER,
    /**
     * Администратор
     */
 ADMIN;

    /**
     * @return имя текущей роли
     */
    @Override
    public String getAuthority() {
        return name();
    }
}