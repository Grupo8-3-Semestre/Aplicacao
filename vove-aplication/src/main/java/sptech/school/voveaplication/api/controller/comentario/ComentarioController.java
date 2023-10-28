package sptech.school.voveaplication.api.controller.comentario;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.comentario.dto.ComentarioDto;
import sptech.school.voveaplication.domain.comentario.repository.ComentarioRepository;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.filtroComentario.FiltroComentario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentarios")
@SecurityRequirement(name = "Bearer")
public class ComentarioController {
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private FiltroComentario filtro;


    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Comentario> Criar(@RequestBody Comentario novoComentario, @RequestParam Long id, @RequestParam Integer tmdbId){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        novoComentario.setUsuario(usuario);
        novoComentario.setTmdbIdFilme(tmdbId);

        FiltroComentario.filtrarPalavroes(novoComentario);

        Comentario comentarioSalvo = comentarioRepository.save(novoComentario);
        return ResponseEntity.status(201).body(comentarioSalvo);
    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<Comentario>> listar(){
        List<Comentario> listaDeComentario = comentarioRepository.findAll();
        if(listaDeComentario.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaDeComentario);
    }

    @CrossOrigin
    @PutMapping()
    public ResponseEntity<Comentario> atualizar(@RequestBody Comentario comentarioAtualizado, @RequestParam Long idcomentario
            , @RequestParam Long idusuario){
        Optional<Comentario> comentarioProcurado = comentarioRepository.findById(idcomentario);
        if(idusuario == comentarioProcurado.get().getUsuario().getId()) {
            if (comentarioProcurado.isPresent()) {
                comentarioAtualizado.setId(idcomentario);
                Usuario usuario = usuarioRepository.findById(idusuario).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário " +
                        "não encontrado"));
                comentarioAtualizado.setUsuario(usuario);
                Comentario atualizando = comentarioRepository.save(comentarioAtualizado);
                return ResponseEntity.status(201).body(atualizando);
            }
        }
        return ResponseEntity.status(404).build();
    }
    @CrossOrigin
    @DeleteMapping()
    public ResponseEntity<Void> deletar(@RequestParam Long idcomentario, @RequestParam Long idusuario){
        Optional<Comentario> comentarioProcurado = comentarioRepository.findById(idcomentario);
        if(idusuario == comentarioProcurado.get().getUsuario().getId()) {
            if (comentarioProcurado.isPresent()) {
                comentarioRepository.delete(comentarioProcurado.get());
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
    @CrossOrigin
    @GetMapping("ultimos-comentario-filme/{idFilme}")
    public List<ComentarioDto> ultimosComentariosDoFilme(@PathVariable Integer idFilme) {
        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        List<Comentario> todosComentarios = comentarioRepository.findAll();

        List<ComentarioDto> comentariosDoFilme = new ArrayList<>();

        for(int i = 0; i < todosComentarios.size(); i++){
            if(todosComentarios.get(i).getTmdbIdFilme().equals(idFilme)){
                String nomeUsuario = todosComentarios.get(i).getUsuario().getNome();
                Integer avaliacao = todosComentarios.get(i).getAvaliacao();
                String descricao = todosComentarios.get(i).getDescricao();
                Boolean spoiler = todosComentarios.get(i).getSpoiler();

                ComentarioDto comentarioDto = new ComentarioDto(nomeUsuario, avaliacao,descricao,spoiler);
                comentariosDoFilme.add(comentarioDto);
            }
        }
        return comentariosDoFilme;
    }
}
