package sptech.school.voveaplication.api.controller.lista;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.lista.Lista;
import sptech.school.voveaplication.domain.lista.ListaTabela;
import sptech.school.voveaplication.domain.lista.repository.ListaRepository;
import sptech.school.voveaplication.domain.lista.repository.ListaTabelaRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.filaobj.FilaObj;
import sptech.school.voveaplication.service.pilhaobj.PilhaObj;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listas")
@SecurityRequirement(name = "Bearer")
public class listaController {

    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private ListaTabelaRepository listaTabelaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PilhaObj pilhaDeFilmesRemovidos = new PilhaObj<ListaTabela>(99);


    @PostMapping
    private ResponseEntity<Lista> criarLista(@RequestBody Lista lista, @RequestParam Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        Lista novaLista = listaRepository.save(lista);
        return ResponseEntity.status(201).body(novaLista);
    }

    @PostMapping("/adicionar")
    private ResponseEntity<ListaTabela> adicionarFilme(@RequestBody ListaTabela novoFilmeDaLista,
                                                       @RequestParam Long idUsuario, @RequestParam Long idLista){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        novoFilmeDaLista.setUsuario(usuario);
        Lista lista = listaRepository.findById(idLista).orElseThrow(() -> new OpenApiResourceNotFoundException("Lista não encontrada"));
        novoFilmeDaLista.setListaFilme(lista);

        boolean filmeJaExistente = listaTabelaRepository.existsByUsuarioIdAndListaFilmeIdAndTmdbIdFilme(idUsuario, idLista,
                novoFilmeDaLista.getTmdbIdFilme());
            if(filmeJaExistente) {
                return ResponseEntity.status(404).build();
            }else{
                ListaTabela filmeSalvo = listaTabelaRepository.save(novoFilmeDaLista);
                return ResponseEntity.status(200).body(filmeSalvo);
            }
    }

    @GetMapping
    private ResponseEntity<List<ListaTabela>> verLista (@RequestParam Long idUsuario, @RequestParam Long idLista){
        List<ListaTabela> minhaLista = listaTabelaRepository.findByUsuarioIdAndListaFilmeId(idUsuario, idLista);
        return ResponseEntity.status(200).body(minhaLista);
    }
    @GetMapping("/minhas-listas")
    private ResponseEntity<List<String>> minhasListas(@RequestParam Long idUsuario){
        List<String> listas = listaTabelaRepository.findListasByUsuarioId(idUsuario);
        return ResponseEntity.status(200).body(listas);
    }

    @DeleteMapping
    private ResponseEntity<Void> removerFilme(@RequestParam Long idusuario, @RequestParam Long idLista, @RequestParam int tmdbIdFilme){
        Optional<ListaTabela> filmeProcurado = listaTabelaRepository.findByTmdbIdFilmeAndListaFilmeId(tmdbIdFilme, idLista);
        if(idusuario == filmeProcurado.get().getUsuario().getId()) {
            if (filmeProcurado.isPresent()) {
                if(pilhaDeFilmesRemovidos.cheia()){
                    ResponseEntity.status(404).body("Pilha cheia");
                } else {
                    pilhaDeFilmesRemovidos.empilhar(filmeProcurado.get());
                    System.out.println(pilhaDeFilmesRemovidos.topo());
                    listaTabelaRepository.delete(filmeProcurado.get());
                    return ResponseEntity.status(200).build();
                }
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/desfazer")
    private ResponseEntity<ListaTabela> desfazerRemocao(@RequestParam Long idUsuario, @RequestParam Long idLista){

        ListaTabela filmeRemovido = (ListaTabela) pilhaDeFilmesRemovidos.desempilhar();
        ListaTabela filmeSalvoNovamente = listaTabelaRepository.save(filmeRemovido);
        return ResponseEntity.status(200).body(filmeSalvoNovamente);
    }


}

