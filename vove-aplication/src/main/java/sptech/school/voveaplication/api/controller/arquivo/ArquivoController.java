package sptech.school.voveaplication.api.controller.arquivo;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import sptech.school.voveaplication.domain.arquivo.Arquivo;
import sptech.school.voveaplication.domain.arquivo.repository.ArquivoRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/arquivos")
@SecurityRequirement(name = "Bearer")
public class ArquivoController {

    @Autowired
    private ArquivoRepository arquivoRepository;

    private Path diretorioBase = Paths.get(System.getProperty("java.io.tmpdir"), "arquivos");

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload")
    public ResponseEntity<Arquivo> upload(@RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            if (!Files.exists(this.diretorioBase)) {
                Files.createDirectories(this.diretorioBase);
            }

            String nomeArquivoFormatado = formatarNomeArquivo(image.getOriginalFilename());

            Path filePath = Paths.get(this.diretorioBase.toString(), nomeArquivoFormatado);
            image.transferTo(filePath.toFile());

            Arquivo arquivo = new Arquivo();
            arquivo.setDataUpload(LocalDate.now());
            arquivo.setNomeArquivoOriginal(image.getOriginalFilename());
            arquivo.setNomeArquivoSalvo(nomeArquivoFormatado);

            Arquivo arquivoBanco = arquivoRepository.save(arquivo);

            return ResponseEntity.ok(arquivoBanco);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Não foi possível salvar o arquivo", e);
        }
    }



    @CrossOrigin
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        Optional<Arquivo> arquivoOptional = arquivoRepository.findById(id);

        if (arquivoOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Arquivo arquivoBanco = arquivoOptional.get();

        File file = this.diretorioBase.resolve(arquivoBanco.getNomeArquivoSalvo()).toFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + arquivoBanco.getNomeArquivoOriginal())
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }

    @CrossOrigin
    private String formatarNomeArquivo(String nomeOriginal) {
        return String.format("%s_%s", UUID.randomUUID(), nomeOriginal);
    }
}
