package sptech.school.voveaplication.api.controller.usuario;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.usuario.UsuarioService;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioDetalhesDto;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioLoginDto;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDto;
import sptech.school.voveaplication.service.usuario.dto.UsuarioCriacaoDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioRepository usuarioRepository;

    @PostMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> criar(@RequestBody UsuarioCriacaoDto usuarioCriacaoDto) {
        this.usuarioService.criar(usuarioCriacaoDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioTokenDto usuarioTokenDto = this.usuarioService.autenticar(usuarioLoginDto);

        return ResponseEntity.status(200).body(usuarioTokenDto);
    }

    @PutMapping("/id")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> atualizar(@RequestParam Long id,@RequestBody UsuarioCriacaoDto usuarioAtualizar){

        this.usuarioService.atualizar(1L, usuarioAtualizar);

        return ResponseEntity.status(200).build();


//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if (usuario.isPresent()) {
//            usuarioAtualizar.setId(id);
//            Usuario usuariooSalvo = usuarioRepository.save(usuarioAtualizar);
//            return ResponseEntity.status(200).body(usuariooSalvo);
//        } else {
//            return ResponseEntity.status(404).build();
        }


    }

