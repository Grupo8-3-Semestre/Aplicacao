package sptech.school.voveaplication.api.controller.txt;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/txt")
@SecurityRequirement(name = "Bearer")
public class TxtController {
   @Autowired
   private UsuarioRepository repository;


    @GetMapping("/{id}/exportar-txt")
    public ResponseEntity<FileSystemResource> exportarTxt(@PathVariable Long id) {
        try {
            String nomeArquivo = "usuario_" + id;
            gravaArquivoTxt(nomeArquivo, id);

            File file = new File(nomeArquivo + ".txt");
            Path path = file.toPath();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());
            headers.setContentLength(Files.size(path));

            return ResponseEntity.ok().headers(headers).body(new FileSystemResource(file));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // try-catch para gravar o registro e finalizar
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo");
        }
    }
    public void gravaArquivoTxt(String nomeArq, Long id) {
        Optional<Usuario> optional = this.repository.findById(id);

        if (optional.isPresent()) {
            Usuario usuario = optional.get();

            nomeArq += ".txt";
            int contaRegistroDado = 0;

            // Monta o registro de header
            String header = "00DadosUsuario20231";
            header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            header += "01";

            // Grava o registro de header
            gravaRegistro(header, nomeArq);

            // Monta e grava o registro de corpo
            String corpo = "02";
            corpo += String.format("%-50.50s", usuario.getNome());
            corpo += String.format("%-10.10s", usuario.getDataNasc());
            corpo += String.format("%-10.10s", usuario.getSexo());
            corpo += String.format("%-35.35s", usuario.getEmail());
            corpo += String.format("%08d", usuario.getCep());
            corpo += String.format("%-20.20s", usuario.getGeneroPreferido());
            corpo += String.format("%-3.3s", usuario.getAssinaStreaming());
            corpo += String.format("%02d", usuario.getQtdFrequencia());
            corpo += String.format("%-3.3s", usuario.getBuscaAvaliacao());
            corpo += String.format("%-20.20s", usuario.getAparelhoUtilizado());
            gravaRegistro(corpo, nomeArq);
            contaRegistroDado++;

            // Monta e grava o registro de trailer
            String trailer = "01";
            trailer += String.format("%010d", contaRegistroDado);
            gravaRegistro(trailer, nomeArq);
        }
    }

}
