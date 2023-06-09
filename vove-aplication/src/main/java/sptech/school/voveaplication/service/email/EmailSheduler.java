package sptech.school.voveaplication.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.email.EmailService;
import sptech.school.voveaplication.service.filaobj.FilaObj;

import org.thymeleaf.context.Context;

@Configuration
@EnableScheduling
public class EmailSheduler {

    @Autowired
    private EmailService emailService;

    private UsuarioRepository usuarioRepository;

    String mensagem1 = "Conteudo da mensagem 1";
    String mensagem2 = "Conteúdo da mensagem 2";
    String mensagem3 = "Conteúdo da mensagem 3";
    String mensagem4 = "Conteúdo da mensagem 4";
    String mensagem5 = "Conteúdo da mensagem 5";
    private FilaObj<String> filaMensagens = new FilaObj<String>(5);

    public EmailSheduler() {
        filaMensagens.insert(mensagem1);
        filaMensagens.insert(mensagem2);
        filaMensagens.insert(mensagem3);
        filaMensagens.insert(mensagem4);
        filaMensagens.insert(mensagem5);
    }

    @Scheduled(cron = "0 11 23 ? * THU")
    public void enviarEmailAgendado() {
        String proximaMensagem = filaMensagens.poll();

        String para = "luizbxblu@gmail.com";
        String assunto = "Filmes populares da semana";
        String templateName = "email-template.html";

        Context templateContext = new Context();
        templateContext.setVariable("nome", proximaMensagem);

        emailService.enviarEmail(para, assunto, templateName, templateContext);

        filaMensagens.insert(proximaMensagem);
    }
}
