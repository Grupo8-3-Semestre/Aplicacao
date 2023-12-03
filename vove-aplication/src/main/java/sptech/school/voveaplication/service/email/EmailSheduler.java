//package sptech.school.voveaplication.service.email;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
//import sptech.school.voveaplication.service.email.EmailService;
//import sptech.school.voveaplication.service.filaobj.FilaObj;
//
//import org.thymeleaf.context.Context;
//
//@Configuration
//@EnableScheduling
//public class EmailSheduler {
//
//    @Autowired
//    private EmailService emailService;
//
//    private UsuarioRepository usuarioRepository;
//
//    String mensagem1 = "Ei, já conferiu os filmes populares dessa semana? Vai la vê!!!";
//    String mensagem2 = "Veja os filmes populares dessa semana para assistir e avaliar!!";
//    String mensagem3 = "Não vai ficar de fora de comentar sobre os filmes mais populares do momento né? Acesse aí o nosso site e não fique de fora!!";
//    String mensagem4 = "Foi aqui que pediram sugestões de filmes para assistir? Que tal assistir um dos filmes mais populares do momento?";
//    String mensagem5 = "Confira os filmes que estão bombando nessa semana!!!";
//    private FilaObj<String> filaMensagens = new FilaObj<String>(5);
//
//    public EmailSheduler() {
//        filaMensagens.insert(mensagem1);
//        filaMensagens.insert(mensagem2);
//        filaMensagens.insert(mensagem3);
//        filaMensagens.insert(mensagem4);
//        filaMensagens.insert(mensagem5);
//    }
//
//    @Scheduled(cron = "0 * * * * *")
//    public void enviarEmailAgendado() {
//        String proximaMensagem = filaMensagens.poll();
//
//        String para = "jaqueline.amorim@sptech.school";
//        String assunto = "Filmes populares da semana";
//        String templateName = "email-template.html";
//
//        Context templateContext = new Context();
//        templateContext.setVariable("nome", proximaMensagem);
//
//        emailService.enviarEmail(para, assunto, templateName, templateContext);
//
//        filaMensagens.insert(proximaMensagem);
//        System.out.println("mensagem enviada");
//    }
//}
