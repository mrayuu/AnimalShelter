package com.example.AnimalShelter.config;
import com.example.AnimalShelter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Это класс, который определяет конфигурацию безопасности для веб-приложения.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Это поле, которое используется для доступа к сервису пользователей.
     */
    @Autowired
    private UserService userService;
    /**
     * Это метод, который создает и возвращает NoOpPasswordEncoder
     * @return кодирование пароля
     */
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    /**
     * Это метод, который настраивает объект HttpSecurity для фильтрации запросов и обеспечения безопасности.
     * @param http протокол
     * @return готовый объект HttpSecurity
     * @throws Exception наследует методы общего класса для ошибок
     */
   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.GET,"/", "/login**","/registration", "/403").permitAll()
                        .requestMatchers(HttpMethod.POST,"/", "/login**", "/registration", "/403").permitAll()
                        .requestMatchers(HttpMethod.GET, "/about", "/aboutme", "/animals", "/animals/{id}", "/contacts", "/help")
                        .hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/animals").hasAnyAuthority("USER", "ADMIN")
                        .requestMatchers("/**").hasAnyAuthority("USER", "ADMIN")

                        .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .csrf().disable().cors().and()
                .exceptionHandling().accessDeniedPage("/403");

        return http.build();
    }

    /**
     * Это метод, который используется для конфигурации AuthenticationManager. Он использует сервис пользователей для аутентификации пользователей.
     * @param auth общий параметр
     * @throws Exception наследует методы общего класса для ошибок
     */
    protected void configure (AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService(userService);
    }
}













