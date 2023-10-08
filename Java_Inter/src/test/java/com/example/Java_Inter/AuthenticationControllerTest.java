package com.example.Java_Inter;

import com.example.Java_Inter.controller.AuthenticationController;
import com.example.Java_Inter.model.Usuario;
import com.example.Java_Inter.model.request.RegisterRequest;
import com.example.Java_Inter.service.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class AuthenticationControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    AuthenticationService service;

    @InjectMocks
    private RegisterRequest request;

    @Test
    public void shouldReturnJustOneFromResult() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest();
        request.setFirstName("Caio");

        Usuario usuario = new Usuario();
        usuario.setFirstName("Caio");

        when(service.register(any(RegisterRequest.class)));

        mockMvc.perform(post("/registrar")
                        .content(mapper.writeValueAsString(registerRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(registerRequest.getFirstName()));
    }
}
