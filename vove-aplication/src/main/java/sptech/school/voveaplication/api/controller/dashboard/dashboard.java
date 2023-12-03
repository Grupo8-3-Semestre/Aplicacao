package sptech.school.voveaplication.api.controller.dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.comentario.repository.ComentarioRepository;
import sptech.school.voveaplication.domain.votacao.Votacao;
import sptech.school.voveaplication.domain.votacao.repository.VotacaoRepository;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@SecurityRequirement(name = "Bearer")
public class dashboard {

    @Autowired
    private VotacaoRepository votacaoRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;
    private TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

    @CrossOrigin
    @GetMapping("/total/{usuarioId}")
    public ResponseEntity<Long> totalFilmeAvaliado(@PathVariable Long usuarioId){

        return ResponseEntity.ok().body(comentarioRepository.countFilmesAvaliadosPorUsuario(usuarioId));

    }
    @CrossOrigin
    @GetMapping("/generosMaisVotados/{usuarioId}")
    public ResponseEntity<Map<String, Long>> getGenerosMaisVotadosPorUsuario(@PathVariable Long usuarioId) {
        List<Comentario> votacoes = comentarioRepository.findByUsuarioId(usuarioId);
        Map<String, Long> generoContagem = new HashMap<>();

        for (Comentario votacao : votacoes) {
            Integer tmdbIdFilme = votacao.getTmdbIdFilme();
            MovieDb movie = tmdbMovies.getMovie(tmdbIdFilme, "pt-br");

            List<Genre> genres = movie.getGenres();
            if (genres != null && !genres.isEmpty()) {
                String primeiroGenero = genres.get(0).getName();
                generoContagem.put(primeiroGenero, generoContagem.getOrDefault(primeiroGenero, 0L) + 1);
            }
        }

        if (generoContagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(generoContagem);
        }
    }

    @CrossOrigin
    @GetMapping("/mediaPorGenero/{usuarioId}")
    public ResponseEntity<Map<String, Double>> getMediaPorGenero(@PathVariable Long usuarioId) {
        List<Comentario> votacoes = comentarioRepository.findByUsuarioId(usuarioId);

        if (votacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Integer> contagemPorGenero = new HashMap<>();
        Map<String, Double> somaNotasPorGenero = new HashMap<>();

        for (Comentario votacao : votacoes) {
            Integer tmdbIdFilme = votacao.getTmdbIdFilme();

            // Use a API do TMDb para obter o gênero do filme
            MovieDb movie = tmdbMovies.getMovie(tmdbIdFilme, "pt-br");

            // Calcula a média por gênero
            for (Genre genre : movie.getGenres()) {
                String nomeGenero = genre.getName();

                contagemPorGenero.put(nomeGenero, contagemPorGenero.getOrDefault(nomeGenero, 0) + 1);
                somaNotasPorGenero.put(nomeGenero, somaNotasPorGenero.getOrDefault(nomeGenero, 0.0) + votacao.getAvaliacao());
            }
        }

        // Calcula a média por gênero
        Map<String, Double> mediaPorGenero = new HashMap<>();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.#", symbols);

        contagemPorGenero.forEach((genero, contagem) -> {
            double somaNotas = somaNotasPorGenero.get(genero);
            double media = somaNotas / contagem;
            mediaPorGenero.put(genero, Double.parseDouble(df.format(media)));
        });

        return ResponseEntity.ok(mediaPorGenero);
    }

    @CrossOrigin
    @GetMapping("/mediaGeral/{usuarioId}")
    public ResponseEntity<Map<String, String>> getMediaGeral(@PathVariable Long usuarioId) {
        List<Comentario> votacoes = comentarioRepository.findByUsuarioId(usuarioId);

        if (votacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        double totalAvaliacoes = votacoes.stream().mapToInt(Comentario::getAvaliacao).sum();
        System.out.println(totalAvaliacoes);
        double mediaGeral = totalAvaliacoes / votacoes.size();

        DecimalFormat df = new DecimalFormat("#.#");
        String mediaFormatada = df.format(mediaGeral);

        // Crie um Map com a chave "media" e o valor da média formatada
        Map<String, String> response = new HashMap<>();
        response.put("media", mediaFormatada);

        // Retorne o Map como JSON
        return ResponseEntity.ok(response);
    }



}