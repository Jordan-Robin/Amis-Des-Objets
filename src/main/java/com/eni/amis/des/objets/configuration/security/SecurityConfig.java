package com.eni.amis.des.objets.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String SELECT_USER = "SELECT pseudo, mot_de_passe AS password, 1 FROM UTILISATEURS WHERE " +
            "pseudo=?";
    private static final String SELECT_ROLE = "SELECT u.email, r.ROLE from UTILISATEURS as u INNER JOIN ROLES as r " +
            "ON u.administrateur = r.IS_ADMIN WHERE u.pseudo=?";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(SELECT_USER);
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(SELECT_ROLE);
        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth
                    .requestMatchers(HttpMethod.GET, "/*").permitAll()
                    .requestMatchers("/create-profile").permitAll()
                    .requestMatchers(HttpMethod.GET, "/article/").hasAnyRole("ADMIN")
                    .requestMatchers("/js/*").permitAll()
                    .requestMatchers("/css/*").permitAll()
                    .requestMatchers("/pictures/*").permitAll()
                    .anyRequest().permitAll();
        });

        http.formLogin(form -> form
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/")
        );

        http.logout(logout -> logout
                            .invalidateHttpSession(true)
                            .clearAuthentication(true)
                            .deleteCookies("JSESSIONID")
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .logoutSuccessUrl("/?logout=true")
                            .permitAll()
                   );

        return http.build();
    }

}