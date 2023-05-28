package sptech.school.voveaplication.api.controller.tmdb;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/avaliar")
@SecurityRequirement(name = "Bearer")
    public class TmdbController {
    private TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));


    @CrossOrigin
    @GetMapping("diretor/{moveId}")
    public static String getDiretor(String movieId) throws IOException {
        String apiKey = "d34024db77b2cdff5b20917cc5ddae3f";
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&append_to_response=credits";
        URL apiUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject movieJson = new JSONObject(response.toString());
        JSONArray crewArray = movieJson.getJSONObject("credits").getJSONArray("crew");

        String directorName = "";
        for (int i = 0; i < crewArray.length(); i++) {
            JSONObject crewMember = crewArray.getJSONObject(i);
            String job = crewMember.getString("job");
            if ("Director".equals(job)) {
                directorName = crewMember.getString("name");
                break;
            }
        }

        return directorName;

    }

    @CrossOrigin
    @GetMapping("genero/{moveId}")
    public static String getGenero(int movieId) throws IOException {
        String apiKey = "d34024db77b2cdff5b20917cc5ddae3f";
        TmdbMovies movies = new TmdbApi(apiKey).getMovies();
        MovieDb movie = movies.getMovie(movieId, "pt-br");


        for (Genre genre : movie.getGenres()) {

            return genre.getName();
        }

        return null;

    }



    @CrossOrigin
    @GetMapping("classificacao-indicativa/{moveId}")
    public static String getIdade(int movieId) throws IOException {


        try {
            // Defina as informações do filme

            String apiKey = "d34024db77b2cdff5b20917cc5ddae3f";

            String language = "pt-BR";

            // Faça a solicitação para a API
            String urlString = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey + "&append_to_response=release_dates&region=BR";

            // Estabelecer conexão com a API
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Analisar a resposta JSON
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseBuilder.append(line);
            }
            String response = responseBuilder.toString();
            JSONObject jsonObject = new JSONObject(response);

            // Obter a certificação do filme para o país que você está interessado
            JSONObject releaseDatesObject = jsonObject.getJSONObject("release_dates");
            JSONArray resultsArray = releaseDatesObject.getJSONArray("results");
            JSONObject countryObject = null;
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject resultObject = resultsArray.getJSONObject(i);
                String countryCode = resultObject.getString("iso_3166_1");
                if (countryCode.equals("BR")) { // substitua "BR" pelo código do país que você está interessado
                    countryObject = resultObject;
                    break;
                }
            }
            JSONArray releaseDatesArray = countryObject.getJSONArray("release_dates");
            String certification = releaseDatesArray.getJSONObject(1).getString("certification");


            System.out.println(certification);

            return certification;
            // Fechar a conexão
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }

    @CrossOrigin
    @GetMapping("onde-assistir/{moveId}")
    public static String getOndeAssistir(int movieId) throws IOException {
        String apiKey = "d34024db77b2cdff5b20917cc5ddae3f";

        // Faz a requisição à API do TMDB e obtém a resposta com a lista de provedores de streaming
        URL url = new URL("https://api.themoviedb.org/3/movie/" + movieId + "/watch/providers?api_key=" + apiKey);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        // Converte a resposta da API para um objeto JSON
        JSONObject jsonObject = new JSONObject(content.toString());

        // Verifica se a lista de provedores de streaming está presente na resposta da API
        if (jsonObject.has("results")) {
            JSONObject results = jsonObject.getJSONObject("results");

            // Verifica se a lista de provedores de streaming para o Brasil está presente na resposta da API
            if (results.has("BR")) {
                JSONObject brazilProviders = results.getJSONObject("BR");
                JSONArray flatrate = brazilProviders.getJSONArray("flatrate");

                // Imprime o nome e o logo dos provedores de streaming disponíveis para o Brasil
                for (int i = 0; i < flatrate.length(); i++) {
                    JSONObject provider = flatrate.getJSONObject(i);
                    String providerName = provider.getString("provider_name");
                    String providerLogo = provider.getString("logo_path");
                    System.out.println(provider);
                    System.out.println("Nome do provedor: " + providerName);

                    System.out.println("Logo do provedor: https://image.tmdb.org/t/p/original" + providerLogo);

                    return providerName;
                }
            }
        }
        return null;
    }
    @CrossOrigin
    @GetMapping("nome/{moveId}")
    public static String getNome(int movieId) throws IOException {
        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

         return tmdbMovies.getMovie(movieId,"pt-br").getTitle();

    }
    @CrossOrigin
    @GetMapping("poster/{moveId}")
    public static String getPoster(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

       return tmdbMovies.getMovie(movieId,"pt-br").getPosterPath();

    }

    @CrossOrigin
    @GetMapping("backdrop/{moveId}")
    public static String getBackDrop(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getBackdropPath();

    }

    @CrossOrigin
    @GetMapping("lancamento/{moveId}")
    public static String getData(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

    return tmdbMovies.getMovie(movieId,"pt-br").getReleaseDate();


    }


    @CrossOrigin
    @GetMapping("popularidade/{moveId}")
    public static Number getPopularidade(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getPopularity();


    }
    @CrossOrigin
    @GetMapping("orcamento/{moveId}")
    public static long getOrcamento(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getBudget();


    }


    @CrossOrigin
    @GetMapping("id-filme/{moveId}")
    public static Integer getId(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getId();


    }
    @CrossOrigin
    @GetMapping("duracao/{moveId}")
    public static Integer getTempo(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getRuntime();


    }

    @CrossOrigin
    @GetMapping("sinopse/{moveId}")
    public static String getSinopse(int movieId) throws IOException {

        TmdbMovies tmdbMovies = new TmdbMovies(new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f"));

        return tmdbMovies.getMovie(movieId,"pt-br").getOverview();


    }

    @CrossOrigin
    @GetMapping("trailer/{moveId}")
    public static String getTrailer(int movieId) throws IOException {
        TmdbApi tmdbApi = new TmdbApi("d34024db77b2cdff5b20917cc5ddae3f");

        MovieDb movie = tmdbApi.getMovies().getMovie(movieId, "videos");
        List<Video> videos = movie.getVideos();
        Video trailer = videos.stream()
                .filter(video -> video.getType().equals("Trailer"))
                .findFirst()
                .orElse(null);
        String trailerUrl="";


        if (trailer != null) {
          return trailerUrl = "https://www.youtube.com/watch?v=" + trailer.getKey();
        }

       return "Não possuí trailer";
    }
}
