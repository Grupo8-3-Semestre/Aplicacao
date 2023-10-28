package sptech.school.voveaplication.api.controller.email;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.service.email.EmailService;

@RestController
@RequestMapping("/api/emails")
@SecurityRequirement(name = "Bearer")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @CrossOrigin
    @PostMapping("/enviar")
    public ResponseEntity<String> enviarEmail(@RequestParam String para,@RequestParam String assunto,@RequestParam String conteudo) {

//        emailService.enviarEmail();
//        emailService.enviarEmail(para, assunto, conteudo, templateContext);
        return ResponseEntity.status(200).body("Email enviado");
    }
}

