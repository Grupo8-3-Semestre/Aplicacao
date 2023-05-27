package sptech.school.voveaplication.comentario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sptech.school.voveaplication.api.controller.comentario.ComentarioController;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.comentario.repository.ComentarioRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ComentarioTest {
    @Mock
    private ComentarioRepository comentarioRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private ComentarioController comentarioController;
    @Test
    @DisplayName("verifica se está fazendo comentario")
    void verificaSeEstáFazendoComentario() throws Exception {

        Long idUsuario = 1L;
        Integer tmdbId = 12345;
        Comentario novoComentario = new Comentario();
        novoComentario.setDescricao("Meu comentário");

        Usuario usuario = new Usuario();
        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(java.util.Optional.of(usuario));

        Comentario comentarioSalvo = new Comentario();
        Mockito.when(comentarioRepository.save(ArgumentMatchers.any(Comentario.class))).thenReturn(comentarioSalvo);
        ResponseEntity<Comentario> response = comentarioController.Criar(novoComentario, idUsuario, tmdbId);

        Mockito.verify(comentarioRepository, Mockito.times(1)).save(novoComentario);
        assertEquals(comentarioSalvo, response.getBody());
    }

}
