package sptech.school.voveaplication;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.usuario.UsuarioService;

import java.util.List;

@Configuration
@EnableScheduling
public class EmailSheduler {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Scheduled(cron = "0 33 23 ? * SAT")
    public void enviarEmailAgendado() {

        List<Usuario> listaDeUsuario = usuarioService.listar();

        String emailValido = "luizbxblu@gmail.com";
        for(int i = 0; i <= listaDeUsuario.size(); i++){
            if(listaDeUsuario.get(i).getAceitaEmail()){
                emailValido += listaDeUsuario.get(i).getEmail();
            }
        }

        String para = emailValido;
        String assunto = "Filmes populares da semana";
        String conteudo = "Confira os filmes mais populares desta semana!!";
        emailService.enviarEmail(para, assunto, conteudo);
    }
}
