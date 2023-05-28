package sptech.school.voveaplication.api.controller.filme;


import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.service.csv.GravarOuLerArquivoCSV;
import sptech.school.voveaplication.service.listaobj.ListaObj;

@Tag(name = "Filmes", description = "Requisicoes relacionadas a filmes")
@RestController
@RequestMapping("/filmes")
@SecurityRequirement(name = "Bearer")
public class FilmeController {

    @CrossOrigin
    @GetMapping("/popular")
    public ListaObj<MovieDb> filmesPopulares(){
        //melhores filmes da semana por popularidade e media de nota
        GravarOuLerArquivoCSV csv = new GravarOuLerArquivoCSV();

        TmdbApi tmdbApi = new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f");

        MovieResultsPage movieResults = tmdbApi.getMovies().getPopularMovies("pt-br", 1);

        MovieDb[] movies = movieResults.getResults().toArray(new MovieDb[0]);

        for (int i = 0; i < movies.length - 1; i++) {
            int aux = i;
            for (int j = i + 1; j < movies.length; j++) {
                if (movies[j].getVoteAverage() > movies[aux].getVoteAverage()) {
                    aux = j;
                }
            }
            MovieDb temp = movies[aux];
            movies[aux] = movies[i];
            movies[i] = temp;
        }
        ListaObj<MovieDb> popularMovies = new ListaObj<>(6);
        for (int i = 0; i < 6; i++) {

            popularMovies.adiciona(movies[i]);
        }
        csv.gravaArquivoCsv(popularMovies,"filmes_populares");
        return popularMovies;
    }

    @CrossOrigin
    @GetMapping("pesquisa-binaria")
    public MovieDb pesquisaFilme(@RequestParam String titulo) {
        GravarOuLerArquivoCSV csv2 = new GravarOuLerArquivoCSV();

        TmdbApi tmdbApi = new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f");

        MovieResultsPage movieResults = tmdbApi.getMovies().getPopularMovies("pt-br", 1);

        MovieDb[] movies = movieResults.getResults().toArray(new MovieDb[0]);

        for (int i = 0; i < movies.length; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < movies.length; j++) {
                if (movies[j].getTitle().compareToIgnoreCase(movies[indiceMenor].getTitle()) < 0) {
                    indiceMenor = j;
                }
            }
            MovieDb temp = movies[indiceMenor];
            movies[indiceMenor] = movies[i];
            movies[i] = temp;
        }

        ListaObj<MovieDb> popularMovies = new ListaObj<>(20);
        for (int i = 0; i < 20; i++) {

            popularMovies.adiciona(movies[i]);
        }
        Integer posicaoDoDFilme;

        int esquerda = 0;
        int direita = popularMovies.getTamanho() - 1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            String tituloAtual = popularMovies.getElemento(meio).getTitle();
            if (tituloAtual.equalsIgnoreCase(titulo)) {
                posicaoDoDFilme = meio;
                return popularMovies.getElemento(meio);
            } else if (tituloAtual.compareToIgnoreCase(titulo) < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        csv2.gravaArquivoCsv(popularMovies,"pesquisa-binaria");
        return null;
    }
}


