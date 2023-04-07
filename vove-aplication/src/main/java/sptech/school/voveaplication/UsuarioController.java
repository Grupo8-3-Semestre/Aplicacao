package sptech.school.voveaplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid Usuario novoUsuario) {




        Usuario usuarioCadastrado = this.usuarioRepository.save(novoUsuario);
        UsuarioDTO userDTO = new UsuarioDTO(usuarioCadastrado);

        return ResponseEntity.status(201).body(userDTO);
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<Usuario> autenticar(@PathVariable String email,
                                                 @PathVariable String senha,
                                                Usuario usuario) {

        Optional<Usuario> byEmailSenha = this.usuarioRepository.findByEmailAndSenha(email,senha);

        if(byEmailSenha.isPresent()){
            Integer idUsuario = usuario.getId();
            if (this.usuarioRepository.existsById(idUsuario)) {
                usuario.setAutenticado(true);

                Usuario usuario1 = this.usuarioRepository.save(usuario);
                return ResponseEntity.status(202).body(usuario1);
            }
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuarioResposta = this.usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());

        if(usuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuarioResposta);
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
