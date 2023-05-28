package sptech.school.voveaplication.api.controller.votacao;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.domain.votacao.Votacao;
import sptech.school.voveaplication.domain.votacao.repository.VotacaoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/votacao")
@SecurityRequirement(name = "Bearer")
public class VotacaoController {

    @Autowired
    private VotacaoRepository votacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @CrossOrigin
    @PostMapping("/votos")
    public ResponseEntity<Votacao> votar(@RequestBody Votacao voto, @RequestParam Long id, @RequestParam Integer tmdbId) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        voto.setUsuario(usuario);
        voto.setTmdbIdFilme(tmdbId);

        Optional<Votacao> votoExistente = votacaoRepository.findByUsuarioId(voto.getUsuario().getId());

        if (votoExistente.isPresent()) {
            Votacao votoAtualizado = votoExistente.get();
            votoAtualizado.setAvaliacao(voto.getAvaliacao());
            votacaoRepository.save(votoAtualizado);
        } else {
            votacaoRepository.save(voto);
        }
        return ResponseEntity.status(200).body(voto);
    }

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<Double> Media(@RequestParam Integer tmdbId){
        Double mediaDeVotos = votacaoRepository.mediaDeVotos(tmdbId);
        return ResponseEntity.status(200).body(mediaDeVotos);
    }
}
