package com.example.AnimalShelter.controller;
import com.example.AnimalShelter.entity.AnimalEntity;
import com.example.AnimalShelter.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
/**
 * Класс AnimalController объявляется с помощью аннотации @Controller,
 * что указывает на то, что это контроллер, отвечающий за обработку запросов связанных с животными.
 */
@Controller
@RequestMapping
public class AnimalController {
    /**
     * Аннотация @Autowired гарантирует, что объект animalRepo - репозиторий для связи логики с базой данных -
     * будет автоматически инициализироваться Spring-фреймворком.
     */
    @Autowired
    private AnimalRepo animalRepo;
    /**
     * Получает всех животных из базы данных
     * @param model нужна для передачи данных в представление
     * @return страница представления животных
     */
    @GetMapping("/animals")
    public String animals (Model model) {
        Iterable<AnimalEntity> animals = animalRepo.findAll();
        model.addAttribute("animals", animals);
        return "animals";
    }
    /**
     *  Представление страницы
     * @param model нужна для передачи данных в представление
     * @return  страница для добавления животного
     */
    @GetMapping("/animals/add")
    public String animalsAdd (Model model) {
        return "animals-add";
    }
    /**
     * Добавление животного в базу
     * @param name  имя животного
     * @param gender пол животного
     * @param age возраст животного
     * @param kind вид животного
     * @param breed порода животного
     * @param color цвет животного
     * @param size размер животного
     * @param vaccinations лечение животного
     * @param diseases болезни животного
     * @param description история животного
     * @param model нужна для передачи данных в представление
     * @return обновленная страница со всеми животными
     */
    @PostMapping("/animals/add")
    public  String animalPostAdd (@RequestParam String name,@RequestParam String gender, @RequestParam String age,
                                  @RequestParam String kind, @RequestParam String breed, @RequestParam String color,
                                  @RequestParam String size, @RequestParam String vaccinations, @RequestParam String diseases, @RequestParam String description,  Model model) {
        AnimalEntity animal = new AnimalEntity(name, gender, age, kind,  breed, color, size, vaccinations, diseases, description);
        animalRepo.save(animal);
        return "redirect:/animals";
    }
    /**
     * Индивидуальная страница животного
     * @param id уникальный идентификатор
     * @param model нужна для передачи данных в представление
     * @return Индивидуальная страница животного
     */
    @GetMapping("/animals/{id}")
    public String animalsDetails (@PathVariable(value = "id") long id, Model model) {
        if (!animalRepo.existsById(id)) {
            return "redirect:/animals";
        }

        Optional<AnimalEntity> animal = animalRepo.findById(id);
        ArrayList<AnimalEntity> res = new ArrayList<>();
        animal.ifPresent(res::add);
        model.addAttribute("animal", res);
        return "animals-details";
    }

    /**
     * Изменение информации о животном - вид страницы
     * @param id уникальный идентификатор
     * @param model нужна для передачи данных в представление
     * @return обновленная страница со всеми животными
     */
    @GetMapping("/animals/{id}/edit")
    public String animalsEdit (@PathVariable(value = "id") long id, Model model) {
        if (!animalRepo.existsById(id)) {
            return "redirect:/animals";
        }
        Optional<AnimalEntity> animal = animalRepo.findById(id);
        ArrayList<AnimalEntity> res = new ArrayList<>();
        animal.ifPresent(res::add);
        model.addAttribute("animal", res);
        return "animals-edit";
    }
    /**
     * Получает параметры из формы редактирования определенного животного с помощью id.
     * Затем значения свойств животного обновляются с помощью полученных параметров и сохраняются в базе данных
     * @param id уникальный идентификатор
     * @param name  имя животного
     * @param gender пол животного
     * @param age возраст животного
     * @param kind вид животного
     * @param breed порода животного
     * @param color цвет животного
     * @param size размер животного
     * @param vaccinations лечение животного
     * @param diseases болезни животного
     * @param description история животного
     * @param model нужна для передачи данных в представление
     * @return обновленная страница со всеми животными
     */
    @PostMapping("/animals/{id}/edit")
    public  String animalPostUpdate (@PathVariable(value = "id") long id, @RequestParam String name,@RequestParam String gender,
                                     @RequestParam String age, @RequestParam String kind,  @RequestParam String breed, @RequestParam String color,
                                     @RequestParam String size, @RequestParam String vaccinations, @RequestParam String diseases, @RequestParam String description,  Model model) {
        AnimalEntity animal = animalRepo.findById(id).orElseThrow();
        animal.setName(name);
        animal.setGender(gender);
        animal.setAge(age);
        animal.setKind(kind);
        animal.setBreed(breed);
        animal.setColor(color);
        animal.setSize(size);
        animal.setVaccinations(vaccinations);
        animal.setDiseases(diseases);
        animal.setDescription(description);
        animalRepo.save(animal);
        return "redirect:/animals";
    }

    /**
     * Удаление определенного животного из базы данных
     * @param id уникальный идентификатор
     * @param model нужна для передачи данных в представление
     * @return обновленная страница со всеми животными
     */
    @PostMapping("/animals/{id}/remove")
    public  String animalPostDelete (@PathVariable(value = "id") long id, Model model) {
        AnimalEntity animal = animalRepo.findById(id).orElseThrow();
        animalRepo.delete(animal);
        return "redirect:/animals";
    }
    /**
     * Поиск и сортировка по имени и полу
     * @param filter имя животного
     * @param gender пол животного
     * @param model нужна для передачи данных в представление
     * @return отсортированная страница со всеми животными
     */
    @PostMapping("/animals")
    public  String filter(@RequestParam String filter, @RequestParam String gender,Map<String, Object> model) {
        Iterable<AnimalEntity> animals;

        if (filter!= null && !filter.isEmpty() && gender!= null && !gender.isEmpty()) {
            animals = animalRepo.findByNameStartingWithAndGender(filter, gender);
        } else {
            if (filter!= null && !filter.isEmpty()) {
                animals = animalRepo.findByNameStartingWith(filter);
            } else { if (gender!= null && !gender.isEmpty()) {
                animals = animalRepo.findByGender(gender);
            } else {
                animals = animalRepo.findAll();
            }}
        }
        model.put("animals", animals);
        return "animals";
    }
}
