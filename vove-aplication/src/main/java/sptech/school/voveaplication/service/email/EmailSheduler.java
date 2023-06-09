package sptech.school.voveaplication.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.email.EmailService;
import sptech.school.voveaplication.service.filaobj.FilaObj;

@Configuration
@EnableScheduling
public class EmailSheduler {
    @Autowired
    private EmailService emailService;

    private UsuarioRepository usuarioRepository;

    String mensagem1 = "<html><body>" +
            "<style>" +
            "body {" +
            "  background-color: #f4f4f4;" +
            "  font-family: Arial, sans-serif;" +
            "  margin: 0;" +
            "  padding: 0;" +
            "}" +
            ".container {" +
            "  max-width: 600px;" +
            "  margin: 0 auto;" +
            "  padding: 20px;" +
            "  background-color: #ffffff;" +
            "  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);" +
            "  border-radius: 5px;" +
            "}" +
            "h1 {" +
            "  color: #333333;" +
            "  font-size: 28px;" +
            "  margin-bottom: 20px;" +
            "  text-align: center;" +
            "}" +
            ".movie {" +
            "  display: flex;" +
            "  align-items: center;" +
            "  margin-bottom: 20px;" +
            "}" +
            ".movie-image {" +
            "  width: 120px;" +
            "  margin-right: 20px;" +
            "}" +
            ".movie-info {" +
            "  flex: 1;" +
            "}" +
            ".movie-title {" +
            "  font-size: 20px;" +
            "  font-weight: bold;" +
            "  margin-bottom: 5px;" +
            "}" +
            ".movie-description {" +
            "  font-size: 16px;" +
            "  color: #666666;" +
            "  margin-bottom: 10px;" +
            "}" +
            ".movie-rating {" +
            "  font-size: 14px;" +
            "  color: #999999;" +
            "}" +
            "</style>" +
            "<div class=\"container\">" +
            "<h1>Top 6 Filmes da Semana</h1>" +
            "<div class=\"movie\">" +
            "<img class=\"movie-image\" src=\"caminho-para-imagem-filme-1.jpg\" alt=\"Filme 1\">" +
            "<div class=\"movie-info\">" +
            "<h2 class=\"movie-title\">Filme 1</h2>" +
            "<p class=\"movie-description\">Descrição do filme 1</p>" +
            "<p class=\"movie-rating\">Classificação: 4.5/5</p>" +
            "</div>" +
            "</div>" +
            "<!-- Repita a estrutura .movie para os outros filmes -->" +
            "<div class=\"movie\">" +
            "<img class=\"movie-image\" src=\"caminho-para-imagem-filme-6.jpg\" alt=\"Filme 6\">" +
            "<div class=\"movie-info\">" +
            "<h2 class=\"movie-title\">Filme 6</h2>" +
            "<p class=\"movie-description\">Descrição do filme 6</p>" +
            "<p class=\"movie-rating\">Classificação: 3.8/5</p>" +
            "</div>" +
            "</div>" +
            "</div>" +
            "</body></html>";
//    String mensagem2 = "Conteúdo da mensagem 2";
//    String mensagem3 = "Conteúdo da mensagem 3";
//    String mensagem4 = "Conteúdo da mensagem 4";
//    String mensagem5 = "Conteúdo da mensagem 5";
    private FilaObj<String> filaMensagens = new FilaObj<String>(5);

    public EmailSheduler() {
        filaMensagens.insert(mensagem1);
//        filaMensagens.insert(mensagem2);
//        filaMensagens.insert(mensagem3);
//        filaMensagens.insert(mensagem4);
//        filaMensagens.insert(mensagem5);
    }
    @Scheduled(cron = "0 37 21 ? * THU")
//    @Scheduled(cron = "0 */1 * * * *")
    public void enviarEmailAgendado() {


        String proximaMensagem = filaMensagens.poll();

        String para = "luizbxblu@gmail.com";
        String assunto = "Filmes populares da semana";
        String conteudo = proximaMensagem;
        emailService.enviarEmail(para, assunto, conteudo);

        filaMensagens.insert(proximaMensagem);
    }
}
