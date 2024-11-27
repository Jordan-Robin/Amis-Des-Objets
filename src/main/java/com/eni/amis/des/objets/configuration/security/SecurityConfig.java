package com.eni.amis.des.objets.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private static final String SELECT_USER = "SELECT pseudo, mot_de_passe AS password, 1 FROM UTILISATEURS WHERE " +
            "pseudo=?";
    private static final String SELECT_ROLE = "SELECT u.email, r.ROLE from UTILISATEURS as u INNER JOIN ROLES as r " +
            "ON u.administrateur = r.IS_ADMIN WHERE u.pseudo=?";

    //@Bean
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
                    // Tous les rôles peuvent accéder à l'url racine (page d'accueil par xemple)
                    .requestMatchers(HttpMethod.GET, "/*").permitAll()
                    // Tous les rôles peuvent accéder à la page d'accueil et d'article
                    .requestMatchers(HttpMethod.GET, "/article/").hasAnyRole("USER", "ADMIN")
                    // Seul un admin peut créer un article
                    .requestMatchers(HttpMethod.POST, "/article/creer").hasRole("ADMIN")
                    // Seul un admin peut aller sur l'url admin
                    .requestMatchers("/admin").hasRole("ADMIN")
                    // Permettre à tout le monde d'afficher correctement images et css
                    .requestMatchers("/css/*").permitAll()
                    .requestMatchers("/images/*").permitAll()
                    // Toutes les autres url ne sont pas permises
                    .anyRequest().denyAll();
        });
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }



}