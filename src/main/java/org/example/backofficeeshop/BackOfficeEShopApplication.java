package org.example.backofficeeshop;

import org.example.backofficeeshop.dto.SignInRequest;
import org.example.backofficeeshop.dto.SignUpRequest;
import org.example.backofficeeshop.model.Role;
import org.example.backofficeeshop.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.example.backofficeeshop.model.Role.ADMIN;
import static org.example.backofficeeshop.model.Role.LOGISTIQUE;

@SpringBootApplication
public class BackOfficeEShopApplication {



    public static void main(String[] args) {
        SpringApplication.run(BackOfficeEShopApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = SignUpRequest.builder()
                    .username("ADMIN.SOUHA")
                    .nom("Admin")
                    .prenom("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.signup(admin).getToken());

            var manager = SignUpRequest.builder()
                    .username("logistique.com")
                    .nom("logistique")
                    .prenom("logistique")
                    .email("logistique@mail.com")
                    .password("password123")
                    .role(LOGISTIQUE)
                    .build();
            System.out.println("Manager token: " + service.signup(manager).getToken());

        };
    }
}
