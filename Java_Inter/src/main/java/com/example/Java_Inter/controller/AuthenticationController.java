package com.example.Java_Inter.controller;

import com.example.Java_Inter.model.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @PostMapping("/registrar")
    public ResponseEntity<AuthenticationResponse> registrar(@RequestBody RegistrarRequest request){

    }

    @PostMapping("/autenticar")
    public ResponseEntity<AuthenticationResponse> registrar(@RequestBody AutenticarRequest request){

    }

}
