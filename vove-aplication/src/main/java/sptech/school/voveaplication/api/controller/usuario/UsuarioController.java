package sptech.school.voveaplication.api.controller.usuario;

import org.aspectj.weaver.patterns.ReferencePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.repository.UsuarioRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.service.usuario.UsuarioService;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioLoginDTO;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDTO;
import sptech.school.voveaplication.service.usuario.dto.UsuarioCriacaoDTO;
import sptech.school.voveaplication.service.usuario.dto.UsuarioDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/criar")
    public ResponseEntity<Void> cadastrar(@RequestBody UsuarioCriacaoDTO novoUsuario) {

        this.usuarioService.criar(novoUsuario);
        return ResponseEntity.status(201).build();

//        Usuario usuarioCadastrado = this.usuarioRepository.save(novoUsuario);
//        UsuarioDTO userDTO = new UsuarioDTO(usuarioCadastrado);
//
//        return ResponseEntity.status(201).body(userDTO);
    }

//    @PostMapping("/{email}/{senha}")
//    public ResponseEntity<Usuario> autenticar(@PathVariable String email,
//                                                 @PathVariable String senha,
//                                                Usuario usuario) {
//
//        Optional<Usuario> byEmailSenha = this.usuarioRepository.findByEmailAndSenha(email,senha);
//
//        if(byEmailSenha.isPresent()){
//            Integer idUsuario = usuario.getId();
//            if (this.usuarioRepository.existsById(idUsuario)) {
//                usuario.setAutenticado(true);
//
//                Usuario usuario1 = this.usuarioRepository.save(usuario);
//                return ResponseEntity.status(202).body(usuario1);
//            }
//        }
//        return ResponseEntity.status(400).build();
//    }

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
    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDTO> login(@RequestBody UsuarioLoginDTO usuarioLoginDTO){
        UsuarioTokenDTO usuarioToken = this.usuarioService.autenticar(usuarioLoginDTO);
        return ResponseEntity.status(200).body(usuarioToken);
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
