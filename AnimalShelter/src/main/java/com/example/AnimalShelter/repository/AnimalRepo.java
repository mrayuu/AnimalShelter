package com.example.AnimalShelter.repository;
import com.example.AnimalShelter.entity.AnimalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Класс `@Repository` является аннотацией Spring Framework, обозначающей, что этот класс является компонентом репозитория данных.
 * Этот класс используется для взаимодействия с базой данных и выполнения операций CRUD (создание, чтение, обновление и удаление).
 * Данный репозиторий нужен для работы с таблицей с животными
 */
@Repository
public interface AnimalRepo extends CrudRepository<AnimalEntity, Long> {
     /**
      *  пользовательский метод, который используется для поиска сущностей животных, имя которых начинается с заданной строки.
      * @param name имя
      * @return список подходящих животных
      */
     List<AnimalEntity> findByNameStartingWith(String name);
     /**
      * пользовательский метод, который используется для поиска сущностей животных по полу.
      * @param gender пол
      * @return список подходящих животных
      */
     List<AnimalEntity> findByGender(String gender);
     /**
      *  пользовательский метод, который используется для поиска сущностей животных,
      *  имя которых начинается с заданной строки, и с возможностью задания пола.
      * @param name имя
      * @param gender пол
      * @return  список подходящих животных
      */
     List<AnimalEntity> findByNameStartingWithAndGender(String name, String gender);
}

