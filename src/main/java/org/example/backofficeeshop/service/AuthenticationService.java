package org.example.backofficeeshop.service;

import lombok.RequiredArgsConstructor;
import org.example.backofficeeshop.dto.JwtAuthenticationResponse;
import org.example.backofficeeshop.dto.SignInRequest;
import org.example.backofficeeshop.dto.SignUpRequest;
import org.example.backofficeeshop.model.Role;
import org.example.backofficeeshop.model.UserEntity;
import org.example.backofficeeshop.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = UserEntity
                .builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .prenom(request.getPrenom())
                .nom(request.getNom())
                .role(request.getRole())
                .build();


        userService.addUser(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }


    public JwtAuthenticationResponse signin(SignInRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        if (authenticate.isAuthenticated()){
            var user = userRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));
            System.out.println(user.getRole());
            var jwt = jwtService.generateToken(user);
            return JwtAuthenticationResponse.builder().token(jwt).user(user).build();
        }
        return JwtAuthenticationResponse.builder().token("test").build();
    }
}