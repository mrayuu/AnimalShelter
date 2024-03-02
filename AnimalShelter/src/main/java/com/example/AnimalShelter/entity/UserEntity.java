package com.example.AnimalShelter.entity;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.management.relation.Role;
import java.util.*;
/**
 * Entity - это аннотация JPA, которая помечает класс как сущность, которая может быть сохранена в базе данных.
 * Table(name = "user") - определяет имя таблицы, которая будет использована для хранения экземпляров класса UserEntity.
 * public class UserEntity implements UserDetails - определяет класс сущности, который реализует UserDetails интерфейс.
 */
@Entity
@Table( name = "user")
public class UserEntity implements UserDetails {
    /**
     * Id - используется для отметки поля класса как первичного ключа.
     * GeneratedValue(strategy = GenerationType.IDENTITY) - опциональная аннотация, используется для указания того, как должен быть сгенерирован первичный ключ.
     * GenerationType.IDENTITY означает, что БД будет генерировать значения первичного ключа автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Номер телефона
     */
    private String phone;
    /**
     * Пароль
     */
    private String password;
    /**
     * Активен ли
     */
    private boolean active;
    /**
     * Кредитная карта
     */
    private Long credit_card;
    /**
     *  Имя
     */
    private String first_name;
    /**
     * Фамилия
     */
    private String last_name;
    /**
     * ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER ) -
     * используется для указания, что роль пользователя является коллекцией объектов типа Role.
     * CollectionTable(name="user_role", joinColumns = @JoinColumn(name = "user_id")) -
     * используется для определения имени таблицы, которая будет использоваться для хранения коллекции ролей пользователя.
     * Задаем роль пользователю
     */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER )
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEntity> roles;
    /**
     * OneToMany(cascade = CascadeType.ALL, mappedBy = "user") - используется для указания отношения «один ко многим» между пользователем и животными.
     * Получаем список животных
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    public List<AnimalEntity> animals;
    /**
     * Конструктор для сущности
     */
    public UserEntity () {
     }
    /**
     * возвращает id.
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * устанавливает id.
     * @param id id пользователя
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * возвращает имя.
     * @return имя
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * устанавливает имя.
     * @param first_name имя
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    /**
     * возвращает фамилию.
     * @return фамилия
     */
    public String getLast_name() {
        return last_name;
    }
    /**
     * устанавливает фамилию.
     * @param last_name фамилия
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * возвращает номер телефона.
     * @return номер телефона
     */
    public String getPhone() {
        return phone;
    }
    /**
     * устанавливает номер телефона.
     * @param phone номер телефона
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * это функция, которая возвращает коллекцию ролей пользователя.
     * @return роль
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
    /**
     * возвращает пароль.
     * @return пароль
     */
    public String getPassword() {
        return password;
    }
    /**
     * реализует метод getUsername() интерфейса UserDetails.
     * @return ничего
     */
    @Override
    public String getUsername() {
        return null;
    }
    /**
     * реализует метод isAccountNonExpired() интерфейса UserDetails. Возвращает информацию о том, действителен ли аккаунт пользователя
     * @return да
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * реализует метод isAccountNonLocked() интерфейса UserDetails. Возвращает информацию о том, действителен ли аккаунт пользователя
     * @return да
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * реализует метод isCredentialsNonExpired() интерфейса UserDetails. Возвращает информацию о том, действителен ли аккаунт пользователя
     * @return да
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * реализует метод isEnabled() интерфейса UserDetails. Возвращает информацию о том, действителен ли аккаунт пользователя
     * @return активен ли пользователь
     */
    @Override
    public boolean isEnabled() {
        return isActive();
    }
    /**
     * это функция, которая устанавливает пароль пользователя.
     * @param password пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * это функция, которая возвращает кредитную карту пользователя.
     * @return карта
     */
    public Long getCredit_card() {
        return credit_card;
    }
    /**
     * функция, которая устанавливает кредитную карту пользователя.
     * @param credit_card карта
     */
    public void setCredit_card(Long credit_card) {
        this.credit_card = credit_card;
    }
    /**
     * функция, которая возвращает список животных пользователя.
     * @return животные
     */
    public List<AnimalEntity>  getAnimals() {
        return animals;
    }
    /**
     * функция, которая возвращает роли пользователя.
     * @return роль
     */
    public Set<RoleEntity> getRoles() {
        return roles;
    }
    /**
     * функция, которая устанавливает роли пользователя.
     * @param roles роль
     */
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
    /**
     * возвращает состояние активности пользователя.
     * @return активность
     */
    public boolean isActive() {
        return active;
    }
    /**
     * устанавливает активность
     * @param active активность
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
