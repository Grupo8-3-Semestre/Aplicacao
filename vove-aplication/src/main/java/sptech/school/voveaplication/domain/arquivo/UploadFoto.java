package sptech.school.voveaplication.domain.arquivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/foto")
public class UploadFoto {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/upload-foto/{id}")
    public ResponseEntity<String> uploadFotoPerfil(@PathVariable Long id, @RequestParam ("file") MultipartFile file) {
        try {
            // Verifique se o usuário com o ID fornecido existe no banco de dados
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
            if (!optionalUsuario.isPresent()) {
                return ResponseEntity.badRequest().body("Usuário não encontrado");
            }

            Usuario usuario = optionalUsuario.get();

            // Verifique se um arquivo foi fornecido
            if (file != null && !file.isEmpty()) {
                // Gere um nome de arquivo único para evitar conflitos
                String nomeArquivo = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

                // Defina o caminho onde você deseja salvar a foto de perfil no servidor
                String caminhoSalvamento = "/foto-usuario";
                // Crie o diretório se ele não existir
                File diretorio = new File(caminhoSalvamento);
                if (!diretorio.exists()) {
                    diretorio.mkdirs();
                }

                // Crie o arquivo no diretório com o nome único gerado
                File arquivo = new File(caminhoSalvamento + nomeArquivo);
                file.transferTo(arquivo);
                // Atualize o caminho da foto de perfil no objeto de usuário
                usuario.setFotoPerfil(nomeArquivo);

                // Salve o usuário atualizado no banco de dados
                usuarioRepository.save(usuario);
                return ResponseEntity.ok("Foto de perfil atualizada com sucesso!");
            } else {
                return ResponseEntity.badRequest().body("Nenhum arquivo fornecido");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao fazer upload da foto de perfil");
        }
    }
}