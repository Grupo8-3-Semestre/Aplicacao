package sptech.school.voveaplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario novoUsuario) {

//        UsuarioDTO userDTO = new UsuarioDTO(novoUsuario);
//        this.usuarioRepository.save(novoUsuario);
//
//        return ResponseEntity.status(201).body(userDTO);

        Usuario usuarioCadastrado = this.usuarioRepository.save(novoUsuario);

        return ResponseEntity.status(201).body(usuarioCadastrado);
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<Usuario> autenticar(@PathVariable String email,
                                                 @PathVariable String senha,
                                                 Usuario usuario) {

        Optional<Usuario> byEmail = this.usuarioRepository.findByEmail(email);
        Optional<Usuario> bySenha = this.usuarioRepository.findBySenha(senha);

        if(byEmail.isPresent() && bySenha.isPresent()){
            usuario.setAutenticado(true);
            this.usuarioRepository.save(usuario);
            return ResponseEntity.status(202).body(usuario);
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();

        if(usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarios);
    }

//    @DeleteMapping("/{email}/{senha}")
//    public ResponseEntity<String> deletar(@PathVariable String email,
//                                          @PathVariable String senha) {
//
//        if (this.usuarioRepository.existsByEmail(email) && this.usuarioRepository.existsBySenha(senha)) {
//            this.usuarioRepository.deleteByEmail(email);
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(404).build();
//    }
//
//    @DeleteMapping("/{email}")
//    public ResponseEntity<String> logoff(@PathVariable String email,
//                                              Usuario usuario) {
//
//        Optional<Usuario> byEmail = this.usuarioRepository.findByEmail(email);
//
//        if(byEmail.isPresent()){
//            usuario.setAutenticado(false);
//            return ResponseEntity.status(202).body(String.format("Logoff do usuario "+ usuario.getUsername() + "concluido!"));
//        }
//        return ResponseEntity.status(400).body(String.format("Usuário NÃO está autenticado"));
//    }
}
