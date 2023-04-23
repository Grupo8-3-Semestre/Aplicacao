package sptech.school.voveaplication.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.email.EmailService;

@Configuration
@EnableScheduling
public class EmailSheduler {
    @Autowired
    private EmailService emailService;

    private UsuarioRepository usuarioRepository;

    @Scheduled(cron = "0 46 00 ? * SUN")
    public void enviarEmailAgendado() {

//        List<Usuario> listaUsuario = usuarioRepository.findAll();

//        String emailValido = "luizbxblu@gmail.com";
//        for(int i = 0; i <= listaUsuario.size(); i++){
//            if(listaUsuario.get(i).getAceitaEmail()){
//                emailValido += listaUsuario.get(i).getEmail();
//            }
//        }

//        List<String> emails = new ArrayList<>();
//        emails.add("luizbxblu@gmail.com");
//        emails.add("joao.barbosa@boxdelivery.com.br");
        String para = "luizbxblu@gmail.com";
        String assunto = "Filmes populares da semana";
        String conteudo = "Confira os filmes mais populares desta semana!!";
        emailService.enviarEmail(para, assunto, conteudo);
    }
}
