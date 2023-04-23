package sptech.school.voveaplication;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoveAplicationApplication {
	private TmdbMovies movie;

	public static void main(String[] args)  {
		SpringApplication.run(VoveAplicationApplication.class, args);

		TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

		GravarOuLerArquivoCSV csv = new GravarOuLerArquivoCSV();

		ListaObj<Filme> listaFilme = new ListaObj(7);

//		listaFilme.adiciona(new Filme(
//				tmdbMovies.getMovie(312221,"pt-br").getTitle(),
//				getOndeAssistir(312221),
//				tmdbMovies.getMovie(312221,"pt-br").getVoteAverage(),
//				tmdbMovies.getMovie(312221,"pt-br").getReleaseDate(),
//				getDiretor("312221"),
//				getGenero(312221),
//				tmdbMovies.getMovie(312221,"pt-br").getPopularity(),
//				getIdade(312221),
//				tmdbMovies.getMovie(312221,"pt-br").getBudget(),
//				tmdbMovies.getMovie(312221,"pt-br").getId(),
//				tmdbMovies.getMovie(312221,"pt-br").getRuntime()));
//		listaFilme.exibe();
//		csv.gravaArquivoCsv(listaFilme, "filmes");
//		csv.leArquivoCsv("filmes");
	}
}
