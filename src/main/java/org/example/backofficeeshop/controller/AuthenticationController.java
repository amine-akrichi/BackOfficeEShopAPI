package org.example.backofficeeshop.controller;

import lombok.RequiredArgsConstructor;
import org.example.backofficeeshop.dto.JwtAuthenticationResponse;
import org.example.backofficeeshop.dto.SignInRequest;
import org.example.backofficeeshop.dto.SignUpRequest;
import org.example.backofficeeshop.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signup(request);

    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);

    }
}
