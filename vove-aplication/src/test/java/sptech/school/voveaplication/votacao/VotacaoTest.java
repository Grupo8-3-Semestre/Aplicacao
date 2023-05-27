package sptech.school.voveaplication.votacao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sptech.school.voveaplication.api.controller.comentario.ComentarioController;
import sptech.school.voveaplication.api.controller.votacao.VotacaoController;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.domain.votacao.Votacao;
import sptech.school.voveaplication.domain.votacao.repository.VotacaoRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VotacaoTest {

    @Mock
    private VotacaoRepository votacaoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private VotacaoController votacaoController;


    @Test
    @DisplayName("verifica se a votação está feita")
    void verificaSeVotacaoEstaSendoCriado () {
        Long idUsuario = 1L;
        Integer tmdbId = 12345;
        Integer novaAvaliacao = 5;

        Usuario usuario = new Usuario();
        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuario));

        Mockito.when(votacaoRepository.findByUsuarioId(usuario.getId())).thenReturn(Optional.empty());

        Votacao voto = new Votacao();
        voto.setAvaliacao(novaAvaliacao);
        ResponseEntity<Votacao> response = votacaoController.votar(voto, idUsuario, tmdbId);

        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(idUsuario);
        assertEquals(usuario, voto.getUsuario());

        assertEquals(novaAvaliacao, voto.getAvaliacao());

        Mockito.verify(votacaoRepository, Mockito.times(1)).findByUsuarioId(usuario.getId());
        Mockito.verify(votacaoRepository, Mockito.times(1)).save(voto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(voto, response.getBody());
    }

}
