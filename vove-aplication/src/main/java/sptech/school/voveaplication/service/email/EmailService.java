package sptech.school.voveaplication.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
        private JavaMailSender emailSender;

        public EmailService(JavaMailSender emailSender) {
            this.emailSender = emailSender;
        }

    public void enviarEmail(String para, String assunto, String conteudo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(para);
        mensagem.setSubject(assunto);
        mensagem.setText(conteudo);
        emailSender.send(mensagem);
    }
    }
