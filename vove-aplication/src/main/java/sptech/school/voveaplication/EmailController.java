package sptech.school.voveaplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarEmail(@RequestParam String para,@RequestParam String assunto,@RequestParam String conteudo) {
        emailService.enviarEmail(para, assunto, conteudo);
        return ResponseEntity.status(200).body("Email enviado");
    }
}

