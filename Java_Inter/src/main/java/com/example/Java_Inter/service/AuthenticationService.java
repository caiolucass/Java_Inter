package com.example.Java_Inter.service;

import com.example.Java_Inter.enumeration.TipoUsuario;
import com.example.Java_Inter.model.Usuario;
import com.example.Java_Inter.model.request.AuthenticationRequest;
import com.example.Java_Inter.model.request.RegisterRequest;
import com.example.Java_Inter.model.response.AuthenticationResponse;
import com.example.Java_Inter.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        var usuario = Usuario.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .cpf(request.getFirstName())
                .cnpj(request.getCnpj())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .tipoUsuario(TipoUsuario.FISICA)
                .cpf(request.getFirstName())
                .build();

        repository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

       var usuario = repository.findByEmail(request.getEmail())
               .orElseThrow();
       var jwtToken = jwtService.generateToken(usuario);
       return AuthenticationResponse.builder()
               .token(jwtToken)
               .build();
    }
}
