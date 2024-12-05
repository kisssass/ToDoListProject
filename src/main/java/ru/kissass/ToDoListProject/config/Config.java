package ru.kissass.ToDoListProject.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config
{
    private static final String[] WHITE_LIST_URL = { "/api/v1/auth/**", "/v2/api-docs", "/v3/api-docs",
            "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html", "/api/auth/**",
            "/api/test/**", "/authenticate" };

    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/registration", "/webjars/**").permitAll()
                        .requestMatchers(WHITE_LIST_URL).hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")           // URL выхода
                        .logoutSuccessUrl("/login")     // Перенаправление после выхода
                        .invalidateHttpSession(true)    // Инвалидация сессии
                        .deleteCookies("JSESSIONID")    // Удаление cookies
                        .permitAll()
                );
        return httpSecurity.build();
    }

}