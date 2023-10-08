package com.example.Java_Inter;

import com.example.Java_Inter.enumeration.TipoUsuario;
import com.example.Java_Inter.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UsuarioTest {

    @Test
    public void testDeveRetornarUsuario(){
        Usuario usuario = Usuario.builder()
                .firstName("Caio")
                .lastName("Lucas")
                .cpf("14484348667")
                .cnpj("12345678945612")
                .password("Teste@1234")
                .tipoUsuario(TipoUsuario.FISICA)
                .id(1)
                .build();
        Assertions.assertNotNull(usuario);
    }
}
