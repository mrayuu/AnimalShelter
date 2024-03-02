package com.example.AnimalShelter.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Аннотация @Controller указывает, что данный класс является контроллером в рамках приложения.
 * Это основной контроллер.
 */
@Controller
public class MainController {
    /**
     * Представление главной страницы
     * @param model нужна для передачи данных в представление
     * @return главная страница
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";}
    /**
     * Представление страницы с реквизитами
     * @param model нужна для передачи данных в представление
     * @return страница "Помощь"
     */
    @GetMapping("/help")
    public String help(Model model) {
        model.addAttribute("title", "Главная страница");
        return "help";}
    /**
     * Представление страницы с контактами
     * @param model нужна для передачи данных в представление
     * @return страница "Контакты"
     */
    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("title", "Главная страница");
        return "contacts";}
    /**
     * Представление страницы об авторе
     * @param model нужна для передачи данных в представление
     * @return страница об авторе
     */
    @GetMapping("/aboutme")
    public String aboutme(Model model) {
        model.addAttribute("title", "Главная страница");
        return "aboutme";}
}
