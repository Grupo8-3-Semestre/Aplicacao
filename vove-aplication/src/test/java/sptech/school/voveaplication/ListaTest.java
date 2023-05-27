package sptech.school.voveaplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sptech.school.voveaplication.api.controller.lista.ListaController;
import sptech.school.voveaplication.domain.lista.Lista;
import sptech.school.voveaplication.domain.lista.ListaTabela;
import sptech.school.voveaplication.domain.lista.repository.ListaRepository;
import sptech.school.voveaplication.domain.lista.repository.ListaTabelaRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ListaTest {
    @Mock
    private ListaRepository listaRepository;
    @Mock
    private ListaTabelaRepository listaTabelaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private ListaController listaController;

    @Test
    @DisplayName("Teste para criar uma lista")
    void testeParaCriarUmaLista(){
        // Dados de teste
        Long idUsuario = 1L;
        Lista lista = new Lista();

        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setId(idUsuario);

        Lista listaSalva = new Lista();
        listaSalva.setId(1L);

        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuarioExistente));
        Mockito.when(listaRepository.save(lista)).thenReturn(listaSalva);

        // Executar o método a ser testado
        ResponseEntity<Lista> response = listaController.criarLista(lista,idUsuario);

        // Verificar se a lista foi salva corretamente
        assertEquals(listaSalva, response.getBody());

        // Verificar o código de status retornado
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    @DisplayName("Testa adiconar um filme na lista")
    void testaAdicionarUmFilmeNaLista(){


        Long idUsuario = 1L;
        Long idLista = 1L;
        ListaTabela novoFilmeDaLista = new ListaTabela();
        novoFilmeDaLista.setTmdbIdFilme(123);

        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setId(idUsuario);

        Lista listaExistente = new Lista();
        listaExistente.setId(idLista);

        Mockito.when(usuarioRepository.findById(idUsuario)).thenReturn(Optional.of(usuarioExistente));
        Mockito.when(listaRepository.findById(idLista)).thenReturn(Optional.of(listaExistente));
        Mockito.when(listaTabelaRepository.existsByUsuarioIdAndListaFilmeIdAndTmdbIdFilme(idUsuario, idLista, novoFilmeDaLista.getTmdbIdFilme())).thenReturn(false);
        Mockito.when(listaTabelaRepository.save(novoFilmeDaLista)).thenReturn(novoFilmeDaLista);

        // Executar o método a ser testado
        ResponseEntity<ListaTabela> response = listaController.adicionarFilme(novoFilmeDaLista, idUsuario, idLista);

        // Verificar se o filme foi adicionado corretamente
        assertEquals(novoFilmeDaLista, response.getBody());

        // Verificar o código de status retornado
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }



    }




