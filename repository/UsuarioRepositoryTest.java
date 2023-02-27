package com.blogPessoalItau.Repository;

import com.blogPessoalItau.model.Usuario;
import com.blogPessoalItau.repository.UsuarioRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @BeforeAll
    void start(){
        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(0L, "João da Silva", "joão@email.com", "13465278", "http://i.imgur.com/FETvs20.jpg"));
        usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "manuela@email.com", "13465278", "http://i.imgur.com/NtyGneo.jpg"));
        usuarioRepository.save(new Usuario(0L, "Adiana da Silva", "adriana@email.com", "13465278", "http://i.imgur.com/mB3VM2N.jpg"));
        usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "paulo@email.com", "13465278", "http://i.imgur.com/JR7KUFU.jpg"));
    }
    @Test
    @DisplayName("Retorna 1 usuário")
    public void deveRetornarUmUsuario(){
        Optional <Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
        assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
    }
    @Test
    @DisplayName("Retorna 3 usuário")
    public void deveRetornarTresUsuario() {
        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
        assertEquals(3, listaDeUsuarios.size());
        assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
        assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
        assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
    }
    @AfterAll
    public void end() {
        usuarioRepository.deleteAll();
    }
}
