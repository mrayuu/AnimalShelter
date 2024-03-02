package com.example.AnimalShelter.controller;
import com.example.AnimalShelter.entity.RoleEntity;
import com.example.AnimalShelter.entity.UserEntity;
import com.example.AnimalShelter.repository.UserRepo;
import com.example.AnimalShelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collections;
import java.util.Map;
/**
 * Controller - это аннотация, которая указывает, что данный класс является контроллером и обрабатывает HTTP-запросы для пользователей.
 */
@Controller
@RequestMapping
public class UserController {
    /**
     * Импортируем функции UserService - сервиса, который обрабатывает логику приложения для пользователя.
     */
    @Autowired
    private UserService userService;
    /**
     * Импортируем функции UserRepo - интерфейса репозитория Spring Data JPA для работы с сущностями пользователя.
     */
    @Autowired
    private UserRepo userRepo;
    /**
     * Отображение списка пользователей
     * @param model нужна для передачи данных в представление
     * @return список пользователей
     */
    @GetMapping("/user")
    public String userList (Model model) {
        model.addAttribute("user", userRepo.findAll());
        return "user-list";
    }

    /**
     * Отображение индивидуальной пользовательской страницы
     * @param user переменная пути - нужна, чтобы найти нужного пользователя
     * @param model нужна для передачи данных в представление
     * @return индивидуальная пользовательская страница
     */
    @GetMapping("/user/{user}")
    public String userEdit (@PathVariable UserEntity user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", RoleEntity.values());
        return "user-edit";
    }
    /**
     * Сохранения изменений в пользовательских данных
     * @param id уникальный идентификатор
     * @param phone номер телефона
     * @param first_name имя
     * @param last_name фамилия
     * @param credit_card кредитная карта
     * @param model нужна для передачи данных в представление
     * @return список пользователей
     */
    @PostMapping("/user/{id}")
    public String userSave(@PathVariable(value = "id") long id,@RequestParam String phone,
                           @RequestParam(required = false) String first_name, @RequestParam(required = false) String last_name,
                           @RequestParam(required = false) Long credit_card,  Model model) {
        UserEntity user = userRepo.findById(id).orElseThrow();
        user.setPhone(phone);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setCredit_card(credit_card);
        userRepo.save(user);
        model.addAttribute("user", userRepo.findAll());
        return "redirect:/user";
    }
    /**
     * Удаление пользователя по ID
     * @param id уникальный идентификатор
     * @param model нужна для передачи данных в представление
     * @return список пользователей
     */
    @PostMapping("/user/{id}/remove")
    public  String userDelete (@PathVariable(value = "id") long id, Model model) {
        UserEntity user = userRepo.findById(id).orElseThrow();
        userRepo.delete(user);
        return "redirect:/user";
    }


    /**
     * Отображение формы регистрации новых пользователей
     * @return окно регистрации
     */
    @GetMapping("/registration")
    public String registration () {
        return "registration";
    }

    /**
     * Метод для добавления нового пользователя в систему. Он проверяет, не существует ли уже пользователь с таким же номером телефона,
     * и сохраняет нового пользователя в репозиторий, если он проходит проверку.
     * @param user пользователь
     * @param model нужна для передачи данных в представление
     * @return окно входа
     */
    @PostMapping("/registration")
    public  String addUser (UserEntity user, Map<String, Object> model) {
        UserEntity userFromDb = userRepo.findByPhone(user.getPhone());

        if (userFromDb != null) {
            model.put("message", "User exists");
            return "registration";
        }
        if (user.getPhone()!= null && user.getPassword()!= null) {
            user.setActive(true);
            user.setRoles(Collections.singleton(RoleEntity.USER));

            userRepo.save(user);
            return "redirect:/login";
        } else {
            model.put("message", "Error");
            return "registration";
        }

    }

    /**
     *  Метод для отображения страницы ошибки доступа 403.
     *  Он используется для предотвращения некоторых пользователей от доступа к определенным страницам приложения.
     * @param user пользователь
     * @return страница ошибки
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(UserEntity user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getFirst_name()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }
}
