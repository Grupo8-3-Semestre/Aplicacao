package sptech.school.voveaplication.api.controller.lista;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sptech.school.voveaplication.api.controller.tmdb.TmdbController;
import sptech.school.voveaplication.api.controller.votacao.VotacaoController;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.filme.dto.FilmeDtoResultado;
import sptech.school.voveaplication.domain.filme.dto.FilmesDasListasInfosDto;
import sptech.school.voveaplication.domain.lista.Lista;
import sptech.school.voveaplication.domain.lista.ListaDtoResposta;
import sptech.school.voveaplication.domain.lista.ListaTabela;
import sptech.school.voveaplication.domain.lista.repository.ListaRepository;
import sptech.school.voveaplication.domain.lista.repository.ListaTabelaRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.pilhaobj.PilhaObj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listas")
@SecurityRequirement(name = "Bearer")
@Service
public class ListaController {

    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private ListaTabelaRepository listaTabelaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PilhaObj pilhaDeFilmesRemovidos = new PilhaObj<ListaTabela>(99);

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Lista> criarLista(@RequestBody Lista lista, @RequestParam Long idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        lista.setUsuario(usuario);
        Lista novaLista = listaRepository.save(lista);
        return ResponseEntity.status(201).body(novaLista);
    }

    @CrossOrigin
    @PostMapping("/adicionar")
    public ResponseEntity<ListaTabela> adicionarFilme(@RequestBody ListaTabela novoFilmeDaLista,
                                                       @RequestParam Long idUsuario, @RequestParam Long idLista){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));
        novoFilmeDaLista.setUsuario(usuario);
        Lista lista = listaRepository.findById(idLista).orElseThrow(() -> new OpenApiResourceNotFoundException("Lista não encontrada"));
        novoFilmeDaLista.setListaFilme(lista);

        boolean filmeJaExistente = listaTabelaRepository.existsByUsuarioIdAndListaFilmeIdAndTmdbIdFilme(idUsuario, idLista,
                novoFilmeDaLista.getTmdbIdFilme());
            if(filmeJaExistente) {
                return ResponseEntity.status(422).build();
            }else{
                ListaTabela filmeSalvo = listaTabelaRepository.save(novoFilmeDaLista);
                return ResponseEntity.status(200).body(filmeSalvo);
            }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<ListaTabela>> verLista (@RequestParam Long idUsuario, @RequestParam Long idLista){
        List<ListaTabela> minhaLista = listaTabelaRepository.findByUsuarioIdAndListaFilmeId(idUsuario, idLista);
        return ResponseEntity.status(200).body(minhaLista);
    }

    @CrossOrigin
    @GetMapping("/minhas-listas")
    public List<ListaDtoResposta> minhasListas(@RequestParam Long idUsuario) {


        List<Lista> todasAsListas = listaRepository.findAll();

        List<ListaDtoResposta> listaDeDto = new ArrayList<>();

        for(int i = 0; i < todasAsListas.size(); i++){
            if(todasAsListas.get(i).getUsuario().getId().equals(idUsuario)){
                Long idLista = todasAsListas.get(i).getId();
                String nomeLista = todasAsListas.get(i).getNomeDaLista();

                ListaDtoResposta respostaDto = new ListaDtoResposta(idLista,nomeLista);
                listaDeDto.add(respostaDto);
            }
        }
        return listaDeDto;
    }


    @CrossOrigin
    @DeleteMapping
    public ResponseEntity<Void> removerFilme(@RequestParam Long idUsuario, @RequestParam Long idLista, @RequestParam int tmdbIdFilme){
        Optional<ListaTabela> filmeProcurado = listaTabelaRepository.findByTmdbIdFilmeAndListaFilmeId(tmdbIdFilme, idLista);
        if(idUsuario == filmeProcurado.get().getUsuario().getId()) {
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

    @CrossOrigin
    @PostMapping("/desfazer")
    public ResponseEntity<ListaTabela> desfazerRemocao(@RequestParam Long idUsuario, @RequestParam Long idLista){

        ListaTabela filmeRemovido = (ListaTabela) pilhaDeFilmesRemovidos.desempilhar();
        ListaTabela filmeSalvoNovamente = listaTabelaRepository.save(filmeRemovido);
        return ResponseEntity.status(200).body(filmeSalvoNovamente);
    }

    @CrossOrigin
    @GetMapping("filmes-da-lista-info")
    public List<FilmesDasListasInfosDto> filmesDaMinhaLista(@RequestParam Long idUsuario, @RequestParam Long idLista) throws IOException {
        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        List<ListaTabela> minhaLista = listaTabelaRepository.findByUsuarioIdAndListaFilmeId(idUsuario, idLista);

        List<FilmesDasListasInfosDto> FilmesDoUsuarioDessaLista = new ArrayList<>();

        for(int i = 0; i < minhaLista.size(); i++){

            Integer idFilme = minhaLista.get(i).getTmdbIdFilme();
            //String mediaUrl = "4.5"; //"https://vove-aplication-1686536532334.azurewebsites.net/votacao?tmdbId=" + idFilme; //Substitua pela URL correta do endpoint
            String mediaUrl = "https://vovefilme.ddns.net/api/votacao?tmdbId=" + idFilme;
            ResponseEntity<Double> response = new RestTemplate().getForEntity(mediaUrl, Double.class);
            Double avaliacao = response.getBody();
            String ondeAssistir = TmdbController.getOndeAssistir(idFilme);
            String nomeFilme = tmdbMovies.getMovie(idFilme, "pt-br").getTitle();
            String genero = TmdbController.getGenero(idFilme);
            String lancamento = tmdbMovies.getMovie(idFilme, "pt-br").getReleaseDate();
            Integer duracaoFilme = TmdbController.getTempo(idFilme);
            String poster = tmdbMovies.getMovie(idFilme, "pt-br").getPosterPath();

            FilmesDasListasInfosDto filmeDto = new FilmesDasListasInfosDto(avaliacao, ondeAssistir, nomeFilme,genero, lancamento,
                    duracaoFilme,idFilme, poster);
            FilmesDoUsuarioDessaLista.add(filmeDto);
        }
        return FilmesDoUsuarioDessaLista;
    }




}

