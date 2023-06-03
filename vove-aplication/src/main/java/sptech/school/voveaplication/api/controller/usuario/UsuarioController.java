package sptech.school.voveaplication.api.controller.usuario;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
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
@SecurityRequirement(name = "Bearer")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private UsuarioRepository usuarioRepository;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody @Valid UsuarioCriacaoDto usuarioCriacaoDto) {
        this.usuarioService.criar(usuarioCriacaoDto);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioTokenDto usuarioTokenDto = this.usuarioService.autenticar(usuarioLoginDto);

        usuarioTokenDto.setLogado(true);

        return ResponseEntity.status(200).body(usuarioTokenDto);
    }

//    @CrossOrigin
//    @GetMapping("/logado")
//    public ResponseEntity<UsuarioTokenDto> usuarioAutenticado(@RequestParam long idUsuario){
//        Optional<Usuario> byId = usuarioRepository.findById(idUsuario);
//
//        return ResponseEntity.status(200).body(usuarioTokenDto);
//    }

    @CrossOrigin
    @PostMapping("/deslogar/{usuarioId}")
    public ResponseEntity<Void> deslogarUsuario(@PathVariable Long usuarioId) {
        this.usuarioService.deslogar(usuarioId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PutMapping("/id")
    public ResponseEntity<Void> atualizar(@RequestParam Long id,@RequestBody Usuario usuarioAtualizar) {

        this.usuarioService.atualizar(id, usuarioAtualizar);
        return ResponseEntity.status(200).build();




    }

    @CrossOrigin
    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@RequestParam Long id) {

        this.usuarioService.deletar(id);
        return ResponseEntity.status(204).build();


    }


    @CrossOrigin
    @GetMapping
    public List<Usuario> listar(){
        List<Usuario> usuarios= this.usuarioService.listar();
return usuarios;
    }



}

