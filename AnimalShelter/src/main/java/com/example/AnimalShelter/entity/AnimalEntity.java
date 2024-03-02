package com.example.AnimalShelter.entity;
import jakarta.persistence.*;
/**
 * Entity - аннотация, указывающая, что это класс представляет таблицу базы данных,
 * а каждый идентификатор класса соответствует первичному ключу таблицы.
 * Table - аннотация, позволяющая настроить таблицу базы данных, которую представляет класс.
 * В данном случае, название таблицы "animal".
 */
@Entity
@Table( name = "animal")
public class AnimalEntity {
    /**
     * Задаем уникальный идентификатор как первичный ключ с автоматической генерацией
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя животного
     */
    private String name;
    /**
     * Вид животного
     */
    private String kind;
    /**
     * Порода животного
     */
    private String breed;
    /**
     * Возраст животного
     */
    private String age;
    /**
     * Пол животного
     */
    private String gender;
    /**
     * Цвет животного
     */
    private String color;
    /**
     * Размер животного
     */
    private String size;
    /**
     * Прививки и лечение животного
     */
    private String vaccinations;
    /**
     * Болезни животного
     */
    private String diseases;
    /**
     * Имеет ли дом
     */
    private Boolean has_home;
    /**
     * История животного
     */
    private String description;
    /**
     * ManyToOne - аннотация, определяющая отношение между таблицей AnimalEntity и таблицей UserEntity.
     * Каждый объект AnimalEntity может быть связан с одним объектом UserEntity.
     * JoinColumn - аннотация, указывающая связь между столбцами таблицы AnimalEntity и UserEntity.
     * В данном случае, столбец "user_id" в таблице AnimalEntity связан со столбцом "id" в таблице UserEntity.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    /**
     * Конструктор для сущности
     */
    public AnimalEntity() {
    }
    /**
     * Получить вид животного
     * @return Вид животного
     */
    public String getKind() {
        return kind;
    }

    /**
     * Добавить вид животного
     * @param kind вид животного
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Получить историю животного
     * @return история животного
     */
    public String getDescription() {
        return description;
    }
    /**
     * Добавить историю животного
     * @param description история животного
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Получить id животного
     * @return id животного
     */
    public Long getId() {
        return id;
    }
    /**
     * Добавить id животного
     * @param id id животного
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Получить имя животного
     * @return имя животного
     */
    public String getName() {
        return name;
    }
    /**
     * Добавить имя животного
     * @param animal_name имя животного
     */
    public void setName(String animal_name) {
        this.name = animal_name;
    }
    /**
     * Получить породу животного
     * @return порода животного
     */
    public String getBreed() {
        return breed;
    }
    /**
     * Добавить породу животного
     * @param breed порода животного
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    /**
     * Получить возраст животного
     * @return Возраст животного
     */
    public String getAge() {
        return age;
    }
    /**
     * Добавить возраст животного
     * @param age возраст животного
     */
    public void setAge(String age) {
        this.age = age;
    }
    /**
     * Получить пол животного
     * @return пол животного
     */
    public String getGender() {
        return gender;
    }
    /**
     * Добавить пол животного
     * @param gender пол животного
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Получить цвет животного
     * @return цвет животного
     */
    public String getColor() {
        return color;
    }
    /**
     * Добавить цвет животного
     * @param color цвет животного
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Получить размер животного
     * @return размер животного
     */
    public String getSize() {
        return size;
    }
    /**
     * Добавить размер животного
     * @param size размер животного
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * Получить прививки и лечение животного
     * @return прививки и лечение животного
     */
    public String getVaccinations() {
        return vaccinations;
    }
    /**
     * Добавить прививки и лечение животного
     * @param vaccinations прививки и лечение животного
     */
    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }
    /**
     * Получить болезни животного
     * @return болезни животного
     */
    public String getDiseases() {
        return diseases;
    }
    /**
     * Добавить болезни животного
     * @param diseases болезни животного
     */
    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
    /**
     * Есть ли дом
     * @return да или нет
     */
    public Boolean getHas_home() {
        return has_home;
    }
    /**
     * Есть ли дом
     * @param has_home да или нет
     */
    public void setHas_home(Boolean has_home) {
        this.has_home = has_home;
    }
    /**
     * Получить хозяина животного
     * @return хозяин животного
     */
    public UserEntity getUser() {
        return user;
    }
    /**
     * Добавить хозяина животного
     * @param user хозяин животного
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }
    /**
     * Добавить животное
     * @param name имя
     * @param gender пол
     * @param age возраст
     * @param kind вид
     * @param breed порода
     * @param color цвет
     * @param size размер
     * @param vaccinations прививки и лечение
     * @param diseases болезни
     * @param description история
     */
    public AnimalEntity(String name, String gender,  String age, String kind, String breed,
                        String color, String size, String vaccinations, String diseases,  String description) {
        this.name = name;
        this.kind = kind;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.color = color;
        this.size = size;
        this.vaccinations = vaccinations;
        this.diseases = diseases;
        this.description = description;
    }
}
