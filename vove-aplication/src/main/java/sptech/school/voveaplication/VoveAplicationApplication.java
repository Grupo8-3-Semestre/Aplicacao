package sptech.school.voveaplication;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sptech.school.voveaplication.antigasClasses.Filme;
import sptech.school.voveaplication.service.csv.GravarOuLerArquivoCSV;
import sptech.school.voveaplication.service.listaobj.ListaObj;

@SpringBootApplication
public class 	VoveAplicationApplication {
	private TmdbMovies movie;

	public static void main(String[] args)  {
		SpringApplication.run(VoveAplicationApplication.class, args);

		TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

		GravarOuLerArquivoCSV csv = new GravarOuLerArquivoCSV();

		ListaObj<Filme> listaFilme = new ListaObj(7);

	}
}
