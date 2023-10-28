package sptech.school.voveaplication.api.controller.dashboard;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    private TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

    @CrossOrigin
    @GetMapping("total/{usuarioId}")
    public ResponseEntity<Long> totalFilmeAvaliado(@PathVariable Long usuarioId){

        return ResponseEntity.ok().body(votacaoRepository.countFilmesAvaliadosPorUsuario(usuarioId));

    }
    @CrossOrigin
    @GetMapping("/generosMaisVotados/{usuarioId}")
    public ResponseEntity<Map<String, Long>> getGenerosMaisVotadosPorUsuario(@PathVariable Long usuarioId) {
        List<Votacao> votacoes = votacaoRepository.findByUsuarioId(usuarioId);
        Map<String, Long> generoContagem = new HashMap<>();

        for (Votacao votacao : votacoes) {
            Integer tmdbIdFilme = votacao.getTmdbIdFilme();

            // Use a API do TMDb para obter o gênero do filme
            MovieDb movie = tmdbMovies.getMovie(tmdbIdFilme, "pt-br");

            // Adicione o gênero ao mapa e incremente a contagem
            for (Genre genre : movie.getGenres()) {
                generoContagem.put(genre.getName(), generoContagem.getOrDefault(genre.getName(), 0L) + 1);
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
        List<Votacao> votacoes = votacaoRepository.findByUsuarioId(usuarioId);

        if (votacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Map<String, Integer> contagemPorGenero = new HashMap<>();
        Map<String, Double> somaNotasPorGenero = new HashMap<>();

        for (Votacao votacao : votacoes) {
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
    public ResponseEntity<String> getMediaGeral(@PathVariable Long usuarioId) {
        List<Votacao> votacoes = votacaoRepository.findByUsuarioId(usuarioId);

        if (votacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        double totalAvaliacoes = votacoes.stream().mapToInt(Votacao::getAvaliacao).sum();
        double mediaGeral = totalAvaliacoes / votacoes.size();

        DecimalFormat df = new DecimalFormat("#.#");
        String mediaFormatada = df.format(mediaGeral);

        return ResponseEntity.ok(mediaFormatada);
    }



}
