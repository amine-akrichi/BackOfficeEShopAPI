package org.example.backofficeeshop.config;


import lombok.RequiredArgsConstructor;
import org.example.backofficeeshop.filter.JwtAuthenticationFilter;
import org.example.backofficeeshop.model.Role;
import org.example.backofficeeshop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.example.backofficeeshop.model.Permession.*;
import static org.example.backofficeeshop.model.Role.ADMIN;
import static org.example.backofficeeshop.model.Role.LOGISTIQUE;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService.userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/signin").permitAll()
                        .requestMatchers("/api/v1/signup").permitAll()


                        .requestMatchers("/api/v1/logistique/**").hasAnyRole(ADMIN.name(), LOGISTIQUE.name())

                        .requestMatchers(GET,"/api/v1/logistique/**").hasAnyAuthority(ADMIN_READ.name(),LOGISTIQUE_READ.name())
                        .requestMatchers(POST,"/api/v1/logistique/**").hasAnyAuthority(ADMIN_READ.name(),LOGISTIQUE_CREATE.name())
                        .requestMatchers(PUT,"/api/v1/logistique/**").hasAnyAuthority(ADMIN_READ.name(),LOGISTIQUE_UPDATE.name())
                        .requestMatchers(DELETE,"/api/v1/logistique/**").hasAnyAuthority(ADMIN_READ.name(),LOGISTIQUE_DELETE.name())

                      .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                        .requestMatchers(GET,"/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
                        .requestMatchers(POST,"/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
                        .requestMatchers(PUT,"/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(DELETE,"/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())


                        /*.requestMatchers("/api/v1/compte").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/role").hasRole(ADMIN.name())
                        .requestMatchers("/api/v1/produit").hasRole(Role.MARKETING.name())
                        .requestMatchers("/api/v1/marque").hasRole(Role.LOGISTIQUE.name())
                        .requestMatchers("/api/v1/coleur").hasRole(Role.LOGISTIQUE.name())
                        .requestMatchers("/api/v1/client").hasRole(Role.MARKETING.name())
                        .requestMatchers("/api/v1/livraison").hasRole(Role.MARKETING.name())
                        .requestMatchers("/api/v1/Caracteristique").hasRole(Role.MARKETING.name())*/
                        .anyRequest().authenticated()
                )
                //.cors(Customizer.withDefaults())
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /*@Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }*/
}
